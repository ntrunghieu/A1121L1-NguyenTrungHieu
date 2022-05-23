import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "Servlet_Time", urlPatterns = "/index")
public class Servlet_Time extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//         cách 1
//        PrintWriter printWriter = response.getWriter();
//        printWriter.print("<h1> Result: "+s+"</h1>");


        // cách 2
//        int n1 = Integer.parseInt(request.getParameter("num1"));
//        int n2 = Integer.parseInt(request.getParameter("num2"));
//        int s = n1+n2;
//        request.setAttribute("sum",s);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
//        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        // cach 1
        writer.println("<html>");

        Date today = new Date();

        writer.println("<h1>" + today + "</h1>");
        writer.println("</html>");



    }
}
