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
import java.util.List;

@WebServlet(name = "ServletPage", urlPatterns = "/page")
public class ServletPage extends HttpServlet {
    private UserDAO userDAO;
    public void init() {
        userDAO = new UserDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameCountry").toLowerCase();
//        String sortType = request.getParameter("sortAttribute").toLowerCase();
        if (name==null){
            name="";
        }
        System.out.println(name);
        List<User> users=userDAO.searByCountry(name);
//        List<User> users1=userDAO.sortListUser(sortType);
        request.setAttribute("listUser",users);
//        request.setAttribute("listUser",users1);
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
