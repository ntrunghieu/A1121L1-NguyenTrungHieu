package model.repository.Impl;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import model.repository.ICustomerRepo;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo implements ICustomerRepo {
    private BaseRepo baseRepo=new BaseRepo();


    private static final String SELECT_TYPE_CUS ="select * from customer_type;";
//    private static final String INSERT_CUSTOMERS_SQL = "INSERT INTO customer" + "  (customer_type_id,customer_name, customer_birhday, customer_gender," +
//            "customer_id_card,customer_phone,customer_email,customer_address) VALUES " +
//            " (?, ?, ?,?,?,?,?,?);";
    private final static String UPDATE_CUSTOMER = "UPDATE customer SET customer_type_id = ?,customer_name = ?, " +
        "customer_birhday =?,customer_gender=?,customer_id_card=?,customer_phone=?,customer_email=?, " +
        "customer_address= ? " +
        " WHERE " +
        "customer_id=? ";
    private final static String INSERT_CUSTOMER = "INSERT INTO customer(customer_type_id,customer_name, " +
            "customer_birhday, " +
            "customer_gender,customer_id_card,customer_phone,customer_email,customer_address) VALUES(?,?,?,?,?,?,?,?)";
    private static final String SET_ID = "select * from users where customer_type_id = ? and customer_name = ? and customer_birhday = ?" +
            " and customer_gender = ? and customer_id_card = ? and customer_phone = ? and customer_email = ? and customer_address = ?;";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id =?";
    private static final String SELECT_ALL_CUSTOMERS = "select * from customer";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String DELETE_TRUNCATE_TABLE = "truncate table users";
    private static final String SEARCH_BY_NAME = "select * from customer where customer_name like ? ;";
    private static final String SORT_USERS_SQL_NAME = "select * from users order by name ASC;";
    private static final String SORT_USERS_SQL_EMAIL = "select * from users order by email ASC;";
    private static final String SORT_USERS_SQL_COUNTRY = "select * from users order by country ASC;";
    private static final String SQL_INSERT = "INSERT INTO employee (name, salary, created_date) VALUES (?,?,?)";

    private static final String SQL_UPDATE = "UPDATE employee SET salary=? WHERE name=?";

    private static final String SQL_TABLE_CREATE = "CREATE TABLE employee"

            + "("

            + " id serial,"

            + " name varchar(100) NOT NULL,"

            + " salary numeric(15, 2) NOT NULL,"

            + " created_date timestamp,"

            + " PRIMARY KEY (id)"

            + ")";

    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS employee";

    @Override
    public List<CustomerType> selectAllTypeCustomers() {
        List<CustomerType> customerTypeList=new ArrayList<>();
        try (Connection connection = baseRepo.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TYPE_CUS);) {
//            statement.execute(DELETE_TRUNCATE_TABLE);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int typeId = rs.getInt("customer_type_id");
                String name = rs.getString("customer_type_name");
                customerTypeList.add(new CustomerType(typeId,name));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerTypeList;
    }

//    @Override
//    public void insertCustomer(Customer customer) throws SQLException {
//        System.out.println(INSERT_CUSTOMER);
//        java.sql.Date sqlBod = new java.sql.Date(customer.getBirthday().getTime());
//        try (Connection connection = baseRepo.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER)) {
//            preparedStatement.setInt(1, customer.getTypeId());
//            preparedStatement.setString(2, customer.getName());
//            preparedStatement.setDate(3,sqlBod);
//            preparedStatement.setInt(4, customer.getGender());
//            preparedStatement.setString(5, customer.getPhone());
//            preparedStatement.setString(6, customer.getIdCard());
//            preparedStatement.setString(7, customer.getEmail());
//            preparedStatement.setString(8, customer.getAddress());
//            System.out.println(preparedStatement);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    @Override
    public Customer setIdUser(int typeId, String name, String birthday, int gender, String idCard, String phone, String email, String address) {
        try (Connection connection = baseRepo.getConnection(); PreparedStatement ps = connection.prepareStatement(SET_ID);) {
            ps.setInt(1,typeId);
            ps.setString(2, name);
            ps.setString(3, birthday);
            ps.setInt(4, gender);
            ps.setString(5, idCard);
            ps.setString(6, phone);
            ps.setString(7, email);
            ps.setString(8, address);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                return new Customer(rs.getInt(1), rs.getString(2), rs.getDate(3),
                        rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
            }
        } catch (SQLException x) {
            x.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer selectCustomer(int id) {
        return null;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        List<Customer> customerList=new ArrayList<>();
        try (Connection connection = baseRepo.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);) {
//            statement.execute(DELETE_TRUNCATE_TABLE);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("customer_id");
                int typeId = rs.getInt("customer_type_id");
                String name = rs.getString("customer_name");
                java.util.Date birthday = rs.getDate("customer_birhday");
                int gender = rs.getInt("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                customerList.add(new Customer(id, typeId, name, birthday,gender,idCard,phone,email,address));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public boolean insertCustomer(Customer customer) throws SQLException {
        Connection connection = baseRepo.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
        java.sql.Date sqlBod = new java.sql.Date(customer.getCustomerBirthday().getTime());

        preparedStatement.setInt(1,customer.getCustomerTypeId());
        preparedStatement.setString(2,customer.getCustomerName());
        preparedStatement.setDate(3, sqlBod);
        preparedStatement.setInt(4,customer.getCustomerGender());
        preparedStatement.setString(5,customer.getCustomerIdCard());
        preparedStatement.setString(6,customer.getCustomerPhone());
        preparedStatement.setString(7,customer.getCustomerEmail());
        preparedStatement.setString(8,customer.getCustomerAddress());

        boolean check = preparedStatement.executeUpdate()>0;
        connection.close();

        return check;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = baseRepo.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;


        }
        return rowDeleted;
    }

    @Override
    public void insertCustomerList(List<Customer> list) {

    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        Connection connection = baseRepo.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);

        java.sql.Date sqlBod = new java.sql.Date(customer.getCustomerBirthday().getTime());

        preparedStatement.setInt(1,customer.getCustomerTypeId());
        preparedStatement.setString(2,customer.getCustomerName());
        preparedStatement.setDate(3, sqlBod);
        preparedStatement.setInt(4,customer.getCustomerGender());
        preparedStatement.setString(5,customer.getCustomerIdCard());
        preparedStatement.setString(6,customer.getCustomerPhone());
        preparedStatement.setString(7,customer.getCustomerEmail());
        preparedStatement.setString(8,customer.getCustomerAddress());
        preparedStatement.setInt(9,customer.getCustomerId());

        boolean check = preparedStatement.executeUpdate() > 0;
        connection.close();

        return check;
    }

    @Override
    public Customer accountCustomer(String name, String email, String country) {
        return null;
    }

    @Override
    public Customer getById(int id) {
        try (Connection connection = baseRepo.getConnection(); PreparedStatement
                ps = connection.prepareCall(SELECT_CUSTOMER_BY_ID)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idCus = rs.getInt("customer_id");
                int typeId = rs.getInt("customer_type_id");
                String name = rs.getString("customer_name");
                java.util.Date birthday = rs.getDate("customer_birhday");
                int gender = rs.getInt("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                return  new Customer(idCus, typeId, name, birthday,gender,idCard,phone,email,address);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> searByName(String name){
        List<Customer> customerList = new ArrayList<>();
        //cach 1
        try (Connection connection = baseRepo.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME)) {
            preparedStatement.setString(1, "%" + name + "%");
            System.out.println(SEARCH_BY_NAME);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idCus = rs.getInt("customer_id");
                int typeId = rs.getInt("customer_type_id");
                String name1 = rs.getString("customer_name");
                java.util.Date birthday = rs.getDate("customer_birhday");
                int gender = rs.getInt("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                customerList.add(new Customer(idCus, typeId, name1, birthday,gender,idCard,phone,email,address));
            }
            connection.close();
        } catch (SQLException x) {
            x.printStackTrace();
        }
        return customerList;
    }

    @Override
    public List<Customer> sortListCustomer(String name) {
        return null;
    }
}
