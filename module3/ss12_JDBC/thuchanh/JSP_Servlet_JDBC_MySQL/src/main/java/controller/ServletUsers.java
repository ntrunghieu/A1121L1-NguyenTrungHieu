package controller;

import dao.UserDAO;
import model.bean.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletUsers", urlPatterns = "/users")
public class ServletUsers extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");


        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                // luu du lieu cho DB
                try {
                    insertUser(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                // code thêm mới
                break;
            case "edit":
                // chỉnh sửa
                try {
                    updateUser(request, response);
                } catch (SQLException x) {
                    x.printStackTrace();
                }

                break;
            case "delete":
                // xóa
                try {
                    delete(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "search":
                searchCountry(request,response);
                break;
            case "sortList":
                sort(request,response);
                break;
            default:
                // trả về trang list


        }
    }

    private void sort(HttpServletRequest request, HttpServletResponse response) {
        String sortType = request.getParameter("sortAttribute").toLowerCase();
        if (sortType==null){
            sortType="";
        }
        System.out.println(sortType);
        List<User> users=userDAO.sortListUser(sortType);
        request.setAttribute("listUser",users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/listUsers.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchCountry(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("nameCountry").toLowerCase();
        if (name==null){
            name="";
        }
        System.out.println(name);
        List<User> users=userDAO.searByCountry(name);
        request.setAttribute("listUser",users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/listUsers.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
//        User user=userDAO.getById(id);

//        response.sendRedirect("/users");

//        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/delete.jsp");
//        dispatcher.forward(request, response);


        User user = this.userDAO.getById(id);
        userDAO.deleteUser(id);
        RequestDispatcher dispatcher;
        if(user == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.userDAO.deleteUser(id);
            try {
                response.sendRedirect("/users");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user=userDAO.setIdUser(name,email,country);

        if (userDAO.accountUser(name,email,country)==null && user==null){

                User user1 = new User(name,email,country);
                try {
//            userDAO.insertUser(user);
                    userDAO.insertUser(user1);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


        }



        response.sendRedirect("/users");

    }





    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");



            User user1 = new User(id,name,email,country);
            try {
                userDAO.updateUser(user1);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }






        response.sendRedirect("/users");

//        User user = new User(id,name,email,country);
//
//        userDAO.updateUser(user);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/edit.jsp");
//        dispatcher.forward(request, response);


//        try {
////            userDAO.updateUser(user);
//            userDAO.updateUser(user);
//        } catch (SQLException x) {
//            x.printStackTrace();
//        }
//
//        response.sendRedirect("/users");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }


            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request,response);
                    break;
                case "view":
                    viewUser(request,response);
                    break;
                case "search":
                    searchCountry(request,response);
                    break;
                case "permission":
                    addUserPermission(request, response);
                    break;
                case "test-without-tran":

                    testWithoutTran(request, response);
                    break;
                case "test-use-tran":

                    testUseTran(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }

    }

    private void testUseTran(HttpServletRequest request, HttpServletResponse response) {
        userDAO.insertUpdateUseTransaction();
    }

    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) {
        userDAO.insertUpdateWithoutTransaction();
    }

    private void addUserPermission(HttpServletRequest request, HttpServletResponse response) {
        User user = new User("an","quan.nguyen@codegym.vn","VN");
        int[] permissions = {1,2,4};

        userDAO.addUserTransaction(user,permissions);
    }

    private void viewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.selectUser(id);

        request.setAttribute("user",user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/view.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDAO.selectUser(id);
        request.setAttribute("user", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/edit.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            User user=userDAO.getById(id);
//            List<User> users= userDAO.selectAllUsers();
            request.setAttribute("user",user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/delete.jsp");
            dispatcher.forward(request, response);
        }
         catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> listUser = userDAO.selectAllUsers();
        request.setAttribute("listUser",listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/listUsers.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
