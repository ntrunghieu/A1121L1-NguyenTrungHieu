package controller;

import model.bean.Category;
import model.bean.Patient;
import model.bean.Product;
import model.bean.Records;
import model.repository.ProductRepository;
import model.service.Impl.ProductServiceImpl;
import model.service.ProductService;

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

@WebServlet(name = "controller.ServletProduct", urlPatterns = "/product")
public class ServletProduct extends HttpServlet {
    private ProductService productService=new ProductServiceImpl();
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
                updateProduct(request,response);
                break;
            case "delete":
                // xóa
//                try {
                    deletePatient(request,response);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
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
        List<Product> productList=productService.searByNameProduct(name);

        request.setAttribute("nameSearch",name);
        request.setAttribute("productList",productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/listProduct.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deletePatient(HttpServletRequest request, HttpServletResponse response) {
        String nameCus1=request.getParameter("idDelete1");
//        Patient patient = this.patientService.getById(id);
//        patientService.deletePatient(id);
        RequestDispatcher dispatcher;

        try {
            boolean check = productService.deleteProduct(nameCus1);
            if (check) {
                response.sendRedirect("/product");
            }

        } catch (SQLException  | IOException throwables) {
            throwables.printStackTrace();
        }

//        try {
//            this.productService.deleteProduct(nameCus1);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        try {
//            response.sendRedirect("/product");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        String ten=request.getParameter("tenSP");
        int gia = Integer.parseInt(request.getParameter("gia"));
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
        String mau = request.getParameter("mau");
        int loai = Integer.parseInt(request.getParameter("loai"));

       Product product = new Product(ten,gia,soLuong,mau,loai);
        try {
            boolean check = productService.updateProduct(product);
            if (check) {
                response.sendRedirect("/product");
            } else {
                request.setAttribute("mess", "Fail to edit customer");
                RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/edit.jsp");
                dispatcher.forward(request, response);
            }

        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {

        String ten=request.getParameter("tenSP");
        int gia=Integer.parseInt(request.getParameter("gia"));
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
        String mau = request.getParameter("mau");
        int loai = Integer.parseInt(request.getParameter("loai"));
        Product product = new Product(ten,gia,soLuong,mau,loai);

        try {
            boolean checkProduct = productService.insertProduct(product);

            if (checkProduct ) {
                response.sendRedirect("/product");
            } else {
                request.setAttribute("mess", "Fail to create new customer");
                RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/create.jsp");
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
                showListProduct(request, response);
                break;

        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.selectAllProduct();
        List<Category> categoryList = productService.selectAllCategory();
        request.setAttribute("productList", productList);
        request.setAttribute("categoryList", categoryList);
        String id=request.getParameter("id");
        Product product=productService.getByNameProduct(id);
//        Category category=productService.getByNameCategory(id);
        request.setAttribute("product",product);
//        request.setAttribute("category",category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = productService.selectAllCategory();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList =productService.selectAllCategory();
        List<Product> productList = productService.selectAllProduct();
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/listProduct.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
