package controller;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import model.service.Impl.CustomerService;
import model.service.ICustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ServletCustomer", urlPatterns = "/admin")
public class ServletCustomer extends HttpServlet {
    private ICustomerService customerService = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                // trả về một form để điền dữ liệu
                save(request, response);
                // code thêm mới
                break;
            case "edit":
                // chỉnh sửa
                updateCustomer(request,response);
                break;
            case "delete":
                // xóa
                try {
                    deleteCustomer(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "search":
                searchName(request,response);
            default:
                // trả về trang list
                break;

        }
    }

    private void searchName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("nameSearch").toLowerCase();
        if (name==null){
            name="";
        }
        System.out.println(name);
        List<Customer> customers=customerService.searByName(name);
        request.setAttribute("nameSearch",name);
        request.setAttribute("listCustomer",customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/listCustomer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id=Integer.parseInt(request.getParameter("idDelete1"));
        Customer customer = this.customerService.getById(id);
        customerService.deleteCustomer(id);
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.customerService.deleteCustomer(id);
            try {
                response.sendRedirect("/admin");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        List<CustomerType> customerTypes = customerService.selectAllTypeCustomers();

        String customer_type = request.getParameter("customer_type");
        int customer_type_id = 0;
        for(int i = 0;i<customerTypes.size();i++) {
            if(customer_type.equals(customerTypes.get(i).getCustomerTypeName())){
                customer_type_id = customerTypes.get(i).getCustomerTypeId();
                break;
            }
        }

        String customer_name = request.getParameter("name");
        String customer_birthday = request.getParameter("birthday");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date bod = null;
        try {
            bod = formatter.parse(customer_birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int customer_gender = Integer.parseInt(request.getParameter("gender"));
        String customer_id_card = request.getParameter("idCard");
        String customer_phone = request.getParameter("phone");
        String customer_email = request.getParameter("email");
        String customer_address = request.getParameter("address");

        Customer customer = new Customer(id,customer_type_id, customer_name, bod, customer_gender,
                customer_id_card,
                customer_phone, customer_email, customer_address);
        try {
            boolean check = customerService.updateCustomer(customer);
            if (check) {
                response.sendRedirect("/admin");
            } else {
                request.setAttribute("mess", "Fail to edit customer");
                RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
                dispatcher.forward(request, response);
            }

        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }

    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypes = customerService.selectAllTypeCustomers();
        String customer_type = request.getParameter("customer_type");
        int customer_type_id = 0;
        for(int i = 0;i<customerTypes.size();i++) {
            if(customer_type.equals(customerTypes.get(i).getCustomerTypeName())){
                customer_type_id = customerTypes.get(i).getCustomerTypeId();
                break;
            }
        }
        String customer_name = request.getParameter("name");
//        while ()
        String customer_birthday = request.getParameter("birthday");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date bod = null;
        try {
            bod = formatter.parse(customer_birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int customer_gender = Integer.parseInt(request.getParameter("gender"));
        String customer_id_card = request.getParameter("idCard");
        String customer_phone = request.getParameter("phone");
        String customer_email = request.getParameter("email");
        String customer_address = request.getParameter("address");

        Customer customer = new Customer(customer_type_id, customer_name, bod, customer_gender, customer_id_card,
                customer_phone, customer_email, customer_address);
        try {
            boolean check = customerService.insertCustomer(customer);
            if (check) {
                response.sendRedirect("/admin");
            } else {
                request.setAttribute("mess", "Fail to create new customer");
                RequestDispatcher dispatcher = request.getRequestDispatcher("customer/createCustomerForm.jsp");
                dispatcher.forward(request, response);
            }

        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");


        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                // trả về một form để điền dữ liệu
                showFormCreate(request,response);
//                if (customer.getId()== id  ){
//
//                }else {
//                    thongBao(request,response);
//                }

                // code thêm mới
                break;
            case "edit":
                // chỉnh sửa
                showFormEdit(request,response);
                break;
            case "delete":
                // xóa
//                showFormDelete(request,response);
            default:
                // trả về trang list
                showListCustomer(request, response);
                break;

        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerService.selectAllTypeCustomers();
        request.setAttribute("customerTypeList", customerTypeList);
        int id=Integer.parseInt(request.getParameter("id"));
        Customer customer=customerService.getById(id);
        request.setAttribute("customer",customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerService.selectAllTypeCustomers();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = customerService.selectAllCustomers();
        List<CustomerType> customerTypeList = customerService.selectAllTypeCustomers();

        request.setAttribute("listCustomer", customers);
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/listCustomer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



