package controller;

import model.bean.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletHome", urlPatterns = "/login")
public class ServletLogin extends HttpServlet {
    private static List<Account> accountList = new ArrayList<>();
    static {
        accountList.add(new Account(1, "hieutrung", "123", "ADMIN"));
        accountList.add(new Account(2, "guest1", "123", "USER"));
        accountList.add(new Account(3, "guest2", "123", "USER"));
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean rememberMe = Boolean.parseBoolean(request.getParameter("rememberMe"));
        // xác thực
        Account userLogin =null;
        String role="";
        for (Account account: accountList) {
            if (account.getUsername().equals(username)&&account.getPassword().equals(password)){
                userLogin =account;
                role=account.getRole();
                break;
            }
        }
        String messLogin="";
        HttpSession session=request.getSession();

        if (userLogin !=null && role.equalsIgnoreCase("ADMIN")){
            session.setAttribute("sessionUser",userLogin);
            if (rememberMe){
                Cookie cookieUsername = new Cookie("cookieUsername",username);
                Cookie cookiePassword = new Cookie("cookiePassword",password);
                cookieUsername.setMaxAge(1000);
                cookiePassword.setMaxAge(1000);
                response.addCookie(cookieUsername);
                response.addCookie(cookiePassword);
            }
            // đăng nhập thành công
            response.sendRedirect("/admin");
        }else {
            // đăng nhập thấ bại
            messLogin="Đăng nhập thất bại";
            request.setAttribute("messLogin",messLogin);
            request.getRequestDispatcher("view/login.jsp").forward(request,response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie: cookies) {
//            if (cookie.getName().equals("cookieUsername")){
//              request.setAttribute("cookieUsername",cookie.getValue());
//            }
//            if (cookie.getName().equals("cookiePassword")){
//                request.setAttribute("cookiePassword",cookie.getValue());
//            }
//        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/login.jsp");
        dispatcher.forward(request,response);
    }

}
