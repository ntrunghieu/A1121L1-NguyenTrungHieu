package controller;

import model.bean.HocSinh;
import model.bean.Patient;
import model.bean.Sach;
import model.bean.TheMuonSach;
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
import java.util.Map;

@WebServlet(name = "controller.ServletBook", urlPatterns = "/book")
public class ServletBook extends HttpServlet {
    private SachRepository sachRepository = new SachRepositoryImpl();
    private SachService sachService = new SachServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                // trả về một form để điền dữ liệu
//                save(request, response);
                // code thêm mới
                break;
            case "edit":
                // chỉnh sửa
//                updatePatient(request,response);
                break;
            case "muon":
                // chỉnh sửa
                try {
                    muon(request, response);
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
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

    private void muon(HttpServletRequest request, HttpServletResponse response) throws ParseException, SQLException, IOException, ServletException {
        String idSach = request.getParameter("idSachMuon");
        String id = request.getParameter("idBook");
        String idSachMuon = request.getParameter("idSachMuon");
        String tenSach = request.getParameter("nameBook");
        String tenHocSinh = request.getParameter("tenHocSinh");
        int trangThai = 1;
        String dayIn = request.getParameter("dayIn");
        String dayOut = request.getParameter("dayOut");
        Sach sach = sachRepository.getById(idSach);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date bod1;
        Date bod2;
        bod1 = formatter.parse(dayIn);
        bod2 = formatter.parse(dayOut);

        TheMuonSach theMuonSach = new TheMuonSach(id, idSachMuon, tenHocSinh, trangThai, bod1, bod2);
        Map<String, String> errorMap = sachService.regexMaMuonSach(theMuonSach);

//        boolean checkTheMuonSach = sachRepository.muonSach(theMuonSach);
        if (bod2.after(bod1) && !errorMap.isEmpty() ) {
            SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
            Date bod3;
            Date bod4;
            bod3 = formatter1.parse(dayIn);
            bod4 = formatter1.parse(dayOut);
            TheMuonSach theMuonSach1 = new TheMuonSach(id, idSachMuon, tenHocSinh, trangThai, bod3, bod4);
            boolean checkTheMuonSach = sachRepository.muonSach(theMuonSach1);
            if (checkTheMuonSach ){
                response.sendRedirect("/book");
            }


        } else {
//            Map<String, String> errorMap = sachService.regexMaMuonSach(theMuonSach);
            List<HocSinh> hocSinhList = sachRepository.selectAllStudents();
//            List<TheMuonSach> theMuonSachList =
            request.setAttribute("errorMap",errorMap);
//            Sach sach = sachRepository.getById(idSach);
            request.setAttribute("idBook", id);
            request.setAttribute("sach", sach);
            request.setAttribute("hocSinhList", hocSinhList);
            request.setAttribute("tenHocSinh", tenHocSinh);
            request.setAttribute("dayIn", dayIn);
            request.setAttribute("dayOut", dayOut);
            request.setAttribute("mess", "ngay tra phai lon hon ngay muon");
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/sach/muon.jsp");
            dispatcher.forward(request, response);


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
//                showFormCreate(request,response);
//                if (customer.getId()== id  ){
//
//                }else {
//                    thongBao(request,response);
//                }

                // code thêm mới
                break;
            case "muon":
                // chỉnh sửa
                showFormMuon(request, response);
                break;
            case "delete":
                // xóa
//                showFormDelete(request,response);
                break;
            case "danhSachMuon":
                // xóa
                danhSachMuon(request, response);
                break;
            default:
                // trả về trang list
                showListBook(request, response);
                break;

        }
    }

    private void danhSachMuon(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showFormMuon(HttpServletRequest request, HttpServletResponse response) {
//        List<Sach> sachList = sachRepository.selectAllBooks();
        List<HocSinh> hocSinhList = sachRepository.selectAllStudents();
        String id = request.getParameter("id");
        Sach sach = sachRepository.getById(id);
        request.setAttribute("sach", sach);
        request.setAttribute("id", id);
        request.setAttribute("hocSinhList", hocSinhList);
//        request.setAttribute("sachList", sachList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/sach/muon.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListBook(HttpServletRequest request, HttpServletResponse response) {
        List<Sach> sachList = sachRepository.selectAllBooks();
        request.setAttribute("sachList", sachList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/sach/listBook.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
