package model.repository.Impl;

import model.bean.Category;
import model.bean.Patient;
import model.bean.Product;
import model.repository.ProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private BaseRepository baseRepository=new BaseRepository();
    private static final String SELECT_ALL_PRODUCT =" select * from product ; ";
    private static final String SELECT_ALL_CATEGORY =" select * from category ; ";

    private final static String INSERT_PRODUCT = " INSERT INTO product VALUES(?,?,?,?,?); ";
    private final static String INSERT_CATEGORY = " INSERT INTO category VALUES(?,?); ";

    private static final String SEARCH_BY_NAME_PRODUCT = " select * from product where name_product = ? ;";
    private static final String SEARCH_BY_NAME_CATEGORY = " select * from category where id_category = ? ;";

    private final static String UPDATE_PATIENT = " UPDATE product SET name_product = ?,price = ?, " +
            " quantity =?,color=?, category_id=? " +
            " WHERE " +
            " name_product = ? ";
    private static final String SELECT_PATIENT_BY_ID = "select * from patient where patient_id = ?";
    private static final String DELETE_PATIENT_SQL = " delete from product where name_product = ? ;";
    private static final String SEARCH_BY_NAME = " select * from product where name_product like ? ;";




    @Override
    public List<Product> selectAllProduct() {
        List<Product> productList=new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
//            statement.execute(DELETE_TRUNCATE_TABLE);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                String name = rs.getString("name_product");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                int category = rs.getInt("category_id");
                productList.add(new Product(name,price,quantity,color,category));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Category> selectAllCategory() {
        List<Category> categoryList=new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);) {
//            statement.execute(DELETE_TRUNCATE_TABLE);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_category");
                String name = rs.getString("name_category");
                categoryList.add(new Category(id,name));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoryList;    }

    @Override
    public Product product() {
        Product product=new Product();
        String ten = product.getTenSanPham();
        int gia = product.getGia();
        int soLuong = product.getSoLuong();
        String mau = product.getMau();
        int loai = product.getLoai();

        return new Product(ten,gia,soLuong,mau,loai);
    }

    @Override
    public Category category() {
        Category category=new Category();

        int maLoai = category.getMaCategory();
        String ten = category.getTenCategory();
        return new Category(maLoai,ten);
    }

    @Override
    public boolean insertProduct(Product product) throws SQLException {
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);

        preparedStatement.setString(1,product.getTenSanPham());
        preparedStatement.setInt(2,product.getGia());
        preparedStatement.setInt(3, product.getSoLuong());
        preparedStatement.setString(4, product.getMau());
        preparedStatement.setInt(5,product.getLoai());


        boolean check = preparedStatement.executeUpdate()>0;
        connection.close();

        return check;
    }

    @Override
    public boolean insertCategory(Category category) throws SQLException {
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY);


        preparedStatement.setInt(1,category.getMaCategory());
        preparedStatement.setString(2, category.getTenCategory());

        boolean check = preparedStatement.executeUpdate()>0;
        connection.close();

        return check;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {

        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PATIENT);

        preparedStatement.setString(1,product.getTenSanPham());
        preparedStatement.setInt(2,product.getGia());
        preparedStatement.setInt(3, product.getSoLuong());
        preparedStatement.setString(4, product.getMau());
        preparedStatement.setInt(5,product.getLoai());
        preparedStatement.setString(6,product.getTenSanPham());


        boolean check = preparedStatement.executeUpdate() > 0;
        connection.close();

        return check;
    }

    @Override
    public boolean updateCategory(Category category) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteProduct(String name) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = baseRepository.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PATIENT_SQL);) {
            statement.setString(1, name);
            rowDeleted = statement.executeUpdate() > 0;


        }
        return rowDeleted;
    }

    @Override
    public boolean deleteCategory(String name) throws SQLException {
        return false;
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
        try (Connection connection = baseRepository.getConnection(); PreparedStatement
                ps = connection.prepareCall(SEARCH_BY_NAME_PRODUCT)) {

            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String name1 = rs.getString("name_product");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                int category = rs.getInt("category_id");
                return new Product(name1,price,quantity,color,category);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Category getByNameCategory(String name) {
        return null;
    }

    @Override
    public List<Product> searByNameProduct(String name) {
        List<Product> productList = new ArrayList<>();
        //cach 1
        try (Connection connection = baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME)) {
            preparedStatement.setString(1, "%" + name + "%");
            System.out.println(SEARCH_BY_NAME);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name1 = rs.getString("name_product");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                int category = rs.getInt("category_id");
                productList.add(new Product(name1,price,quantity,color,category));
            }
            connection.close();
        } catch (SQLException x) {
            x.printStackTrace();
        }
        return productList;
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
