package model.service.Impl;

import model.bean.Category;
import model.bean.Patient;
import model.bean.Product;
import model.repository.Impl.ProductRepositoryImpl;
import model.repository.ProductRepository;
import model.service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository=new ProductRepositoryImpl();
    @Override
    public List<Product> selectAllProduct() {
        return productRepository.selectAllProduct();
    }

    @Override
    public List<Category> selectAllCategory() {
        return productRepository.selectAllCategory();
    }

    @Override
    public Product product() {
        return null;
    }

    @Override
    public Category category() {
        return null;
    }

    @Override
    public boolean insertProduct(Product product) throws SQLException {
        return productRepository.insertProduct(product);
    }

    @Override
    public boolean insertCategory(Category category) throws SQLException {
        return productRepository.insertCategory(category);
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        return productRepository.updateProduct(product);
    }

    @Override
    public boolean updateCategory(Category category) throws SQLException {
        return productRepository.updateCategory(category);
    }

    @Override
    public boolean deleteProduct(String name) throws SQLException {
        return productRepository.deleteProduct(name);
    }

    @Override
    public boolean deleteCategory(String name) throws SQLException {
        return productRepository.deleteProduct(name);
    }

    @Override
    public void insertPatientList(List<Patient> list) {

    }

    @Override
    public Patient setIdUser(int typeId, String name, String birthday, int gender, String idCard, String phone, String email, String address) {
        return null;
    }

    @Override
    public Patient selectCustomer(int id) {
        return null;
    }

    @Override
    public Patient accountPatient(String name, String email, String country) {
        return null;
    }

    @Override
    public Product getByNameProduct(String name) {
        return productRepository.getByNameProduct(name);
    }

    @Override
    public Category getByNameCategory(String name) {
        return null;
    }

    @Override
    public List<Product> searByNameProduct(String name) {
        return productRepository.searByNameProduct(name);
    }

    @Override
    public List<Category> searByNameCategory(String name) {
        return null;
    }

    @Override
    public List<Product> sortListProduct(String name) {
        return null;
    }

    @Override
    public List<Category> sortListCategory(String name) {
        return null;
    }
}
