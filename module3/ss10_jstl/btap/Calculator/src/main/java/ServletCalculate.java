import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletCalculate", urlPatterns = "/calculate")
public class ServletCalculate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float first_number = Float.parseFloat(request.getParameter("first_operand"));
        float last_number = Float.parseFloat(request.getParameter("last_operand"));
        String operator = request.getParameter("operator");

        float result =0;
        String message="";
        try {
            result = Calculator.calculate(first_number, last_number, operator);
        } catch (ArithmeticException arithmeticException){
            message=arithmeticException.getMessage();
        }

        request.setAttribute("result", result);
        request.setAttribute("first_number", first_number);
        request.setAttribute("last_number", last_number);
        request.setAttribute("operator", operator);
        request.setAttribute("message", message);
        request.getRequestDispatcher("res.jsp").forward(request,response);
    }
}
