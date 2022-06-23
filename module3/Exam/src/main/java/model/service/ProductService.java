package model.service;

import model.bean.Category;
import model.bean.Patient;
import model.bean.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    public List<Product> selectAllProduct();
    public List<Category> selectAllCategory();


    Product product();
    Category category();

    boolean insertProduct(Product product) throws SQLException;
    boolean insertCategory(Category category) throws SQLException;


    boolean updateProduct(Product product) throws SQLException;
    boolean updateCategory(Category category) throws SQLException;

    boolean deleteProduct(String name) throws SQLException;
    boolean deleteCategory(String name) throws SQLException;

    void insertPatientList(List<Patient> list);

    public Patient setIdUser(int typeId, String name, String birthday, int gender, String idCard, String phone, String email, String address);
    public Patient selectCustomer(int id);




    public Patient accountPatient(String name, String email, String country);

    public Product getByNameProduct(String name);
    public Category getByNameCategory(String name);

    public List<Product> searByNameProduct(String name);
    public List<Category> searByNameCategory(String name);

    public List<Product> sortListProduct(String name);
    public List<Category> sortListCategory(String name);
}
