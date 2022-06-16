package model.repository;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface ICustomerRepo {


    public List<CustomerType> selectAllTypeCustomers();
    public List<Customer> selectAllCustomers();

    //    public void insertCustomer(Customer customer) throws SQLException;
//    public boolean deleteCustomer(int id) throws SQLException;
//    public boolean updateCustomer(Customer customer) throws SQLException;

    boolean insertCustomer(Customer customer) throws SQLException;

    boolean updateCustomer(Customer customer) throws SQLException;

    boolean deleteCustomer(int id) throws SQLException;

    void insertCustomerList(List<Customer> list);

    public Customer setIdUser(int typeId, String name, String birthday, int gender, String idCard, String phone, String email, String address);
    public Customer selectCustomer(int id);




    public Customer accountCustomer(String name, String email, String country);

    public Customer getById(int id);

    public List<Customer> searByName(String name);

    public List<Customer> sortListCustomer(String name);
}
