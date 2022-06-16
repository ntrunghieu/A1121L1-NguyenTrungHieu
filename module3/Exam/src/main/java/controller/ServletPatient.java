package controller;

import model.bean.Patient;
import model.bean.Records;
import model.service.Impl.PatientServiceImpl;
import model.service.PatientService;

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

@WebServlet(name = "ServletPatient", urlPatterns = "/admin")
public class ServletPatient extends HttpServlet {
    private PatientService patientService = new PatientServiceImpl();

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
                updatePatient(request,response);
                break;
            case "delete":
                // xóa
                try {
                    deletePatient(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "search":
                searchName(request,response);
                break;
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
        List<Patient> patientList=patientService.searByName(name);

        request.setAttribute("nameSearch",name);
        request.setAttribute("patientList",patientList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/patient/listPatient.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deletePatient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String nameCus1=request.getParameter("idDelete1");
//        Patient patient = this.patientService.getById(id);
//        patientService.deletePatient(id);
        RequestDispatcher dispatcher;
        this.patientService.deletePatient(nameCus1);
        response.sendRedirect("/admin");
//        if(patient == null){
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        } else {
//
//            try {
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    private void updatePatient(HttpServletRequest request, HttpServletResponse response) {
        String id=request.getParameter("id");
        List<Patient> patientList = patientService.selectAllPatients();


        String patientName = request.getParameter("name");
        String dayIn = request.getParameter("day_in");
        String dayOut = request.getParameter("day_out");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date bod = null;
        Date bod1 = null;

        try {
//            bod = formatter.parse(dayIn);
            bod1 = formatter.parse(dayOut);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String reason = request.getParameter("reason");

        Patient patient = new Patient(id,patientName,bod,bod1,reason);
        try {
            boolean check = patientService.updatePatient(patient);
            if (check) {
                response.sendRedirect("/admin");
            } else {
                request.setAttribute("mess", "Fail to edit customer");
                RequestDispatcher dispatcher = request.getRequestDispatcher("view/patient/edit.jsp");
                dispatcher.forward(request, response);
            }

        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        List<Patient> patientList = patientService.selectAllPatients();
        List<Records> recordsList = patientService.selectAllRecords();
        String idRecord=request.getParameter("idRecord");
        String idPatient=request.getParameter("idPatient");
        String patientName = request.getParameter("name");
        String dayIn = request.getParameter("dayIn");
        String dayOut = request.getParameter("dayOut");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date bod = null;
        Date bod1 = null;
        try {
            bod = formatter.parse(dayIn);
            bod1 = formatter.parse(dayOut);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String reason = request.getParameter("reason");

        Patient patient = new Patient(idPatient,patientName,bod,bod1,reason);
        Records records = new Records(idPatient,idRecord);
//        Map<String, String> errorMap = patientService.creatNewPatient(patient);
//        try {
//            boolean checkPatient = patientService.insertPatient(patient);
//            boolean checkRecords = patientService.insertRecordsList(records);
//            if ( errorMap.isEmpty() && checkRecords ){
//                response.sendRedirect("/admin");
//            } else {
//                request.setAttribute("errorMap", errorMap);
//                request.setAttribute("patient", patient);
//                request.getRequestDispatcher("view/patient/create.jsp").forward(request, response);
//            }
//        } catch (SQLException | ServletException | IOException throwables) {
//            throwables.printStackTrace();
//        }

        try {
            boolean checkPatient = patientService.insertPatient(patient);
            boolean checkRecords = patientService.insertRecordsList(records);
            if (checkPatient && checkRecords) {
                response.sendRedirect("/admin");
            } else {
                request.setAttribute("mess", "Fail to create new customer");
                RequestDispatcher dispatcher = request.getRequestDispatcher("view/patient/create.jsp");
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
                break;
            default:
                // trả về trang list
                showListPatient(request, response);
                break;

        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/patient/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        List<Patient> patientList = patientService.selectAllPatients();
        request.setAttribute("patientList", patientList);
        String id=request.getParameter("id");
        Patient patient=patientService.getById(id);
        request.setAttribute("patient",patient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/patient/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListPatient(HttpServletRequest request, HttpServletResponse response) {
        List<Patient> patientList = patientService.selectAllPatients();
        request.setAttribute("patientList", patientList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/patient/listPatient.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
