import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

@WebServlet(name = "ServletHocSinh")
public class ServletHocSinh extends HttpServlet {
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
//                if (customer.getId()== id  ){
//
//                }else {
//                    thongBao(request,response);
//                }

                // code thêm mới
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
//                showListBook(request, response);
                break;

        }
    }
}
