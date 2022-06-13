package controller;

import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"", "/studentServlet"})
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // List from DAO
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student(1, "Tien", "04/09/2020", 8));
        studentList.add(new Student(2, "Khanh", "03/07/1999", 7));
        studentList.add(new Student(3, "Hai", "05/07/1999", 7));
        studentList.add(new Student(4, "Nhat", "12/07/1999", 7));
        studentList.add(new Student(5, "Toan", "07/06/1999", 9));
        studentList.add(new Student(6, "Tung", "26/07/1999", 8));
        studentList.add(new Student(7, "Hien", "23/07/1999", 9));
        studentList.add(new Student(8, "Chuong", "11/04/1999", 8));
        studentList.add(new Student(9, "Quang", "25/07/1999", 7));
        studentList.add(new Student(10, "Hoang", "03/09/1999", 8));
        studentList.add(new Student(11, "Tra", "02/07/1999", 9));
        studentList.add(new Student(12, "Hoat", "03/12/1999", 7));

        request.setAttribute("studentListAbc", studentList);
        request.getRequestDispatcher("/test-paging-sorting.jsp").forward(request, response);
    }
}
