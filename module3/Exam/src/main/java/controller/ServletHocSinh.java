package controller;

import model.bean.HocSinh;
import model.bean.Patient;
import model.bean.Records;
import model.bean.Sach;
import model.repository.Impl.SachRepositoryImpl;
import model.repository.SachRepository;
import model.service.Impl.SachServiceImpl;
import model.service.SachService;

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

@WebServlet(name = "controller.ServletHocSinh", urlPatterns = "/hocsinh")
public class ServletHocSinh extends HttpServlet {
    private SachService sachService=new SachServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                // trả về một form để điền dữ liệu
                save(request, response);
                break;
            case "edit":
                // chỉnh sửa
//                updatePatient(request,response);
                break;
            case "muon":
                // chỉnh sửa
//                try {
//                    muon(request, response);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
                break;
            case "delete":
                // xóa
//                try {
//                    deletePatient(request,response);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
                break;
            case "search":
//                searchName(request,response);
                break;
            default:
                // trả về trang list
                break;

        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        String idStudent=request.getParameter("idStudent");
        String name=request.getParameter("name");
        String nameClass = request.getParameter("nameClass");
        HocSinh hocSinh=new HocSinh(idStudent,name,nameClass);


        try {
            boolean checkStudent = sachService.insertStudent(hocSinh);

            if (checkStudent) {
                response.sendRedirect("/hocsinh");
            } else {
                request.setAttribute("mess", "Fail to create new customer");
                RequestDispatcher dispatcher = request.getRequestDispatcher("view/hocsinh/create.jsp");
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

                break;
            case "muon":
                // chỉnh sửa
//                showFormMuon(request, response);
                break;
            case "delete":
                // xóa
//                showFormDelete(request,response);
                break;
            case "danhSachMuon":
                // xóa
//                danhSachMuon(request, response);
                break;
            default:
                // trả về trang list
                showListStudent(request, response);
                break;

        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/hocsinh/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListStudent(HttpServletRequest request, HttpServletResponse response) {
        List<HocSinh> hocSinhList = sachService.selectAllStudents();
        request.setAttribute("hocSinhList", hocSinhList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/hocsinh/listStudent.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
