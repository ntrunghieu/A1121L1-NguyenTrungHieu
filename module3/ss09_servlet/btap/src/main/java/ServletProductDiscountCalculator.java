import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletProductDiscountCalculator", urlPatterns = "/display-discount")
public class ServletProductDiscountCalculator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName=request.getParameter("product_name");
        Double listPrice=Double.parseDouble(request.getParameter("list_price"));
        double discount = Double.parseDouble(request.getParameter("discount_percent"));

        double discountAmount=listPrice*discount*0.01;
        double finalAmount= listPrice-discountAmount;
        request.setAttribute("productName",productName);
        request.setAttribute("discount",discountAmount);
        request.setAttribute("finalAmount",finalAmount);
        request.setAttribute("discountRate", discount);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
