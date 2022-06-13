package model.service;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {
    public List<CustomerType> selectAllTypeCustomers();
    public List<Customer> selectAllCustomers();
//    public void insertCustomer(Customer customer) throws SQLException;
//    public boolean deleteCustomer(int id) throws SQLException;
//    public boolean updateCustomer(Customer customer) throws SQLException;

    boolean insertCustomer(Customer customer) throws SQLException;
    boolean updateCustomer(Customer customer) throws SQLException;
    boolean deleteCustomer(int id) throws SQLException;

    public Customer setIdCustomer(int typeId, String name, String birthday, int gender, String idCard, String phone, String email, String address);
    public Customer selectCustomer(int id);




    public Customer accountCustomer(String name, String email, String country);
    public Customer getById(int id);
    public List<Customer> searByCountry(String name);
    public List<Customer> sortListCustomer(String name);
}
