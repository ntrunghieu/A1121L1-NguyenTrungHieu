package controller;

import model.bean.HocSinh;
import model.bean.TheMuonSach;
import model.service.Impl.SachServiceImpl;
import model.service.SachService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletMuon", urlPatterns = "/danhSachMuon")
public class ServletDanhSachMuon extends HttpServlet {
    private SachService sachService=new SachServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                // trả về một form để điền dữ liệu
//                save(request, response);
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");


        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                // trả về một form để điền dữ liệu
//                showFormCreate(request,response);

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
                showList(request, response);
                break;

        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<TheMuonSach> theMuonSachList = sachService.selectAllTagBorrowBook();
        List<HocSinh> hocSinhList = sachService.selectAllStudents();
        request.setAttribute("hocSinhList", hocSinhList);
        request.setAttribute("theMuonSachList", theMuonSachList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/danhSachMuon/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
