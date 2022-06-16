package model.service.Impl;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import model.repository.ICustomerRepo;
import model.repository.Impl.CustomerRepo;
import model.service.ICustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepo customerRepo=new CustomerRepo();

    @Override
    public List<CustomerType> selectAllTypeCustomers() {
        return customerRepo.selectAllTypeCustomers();
    }

//    @Override
//    public void insertCustomer(Customer customer) throws SQLException {
//
//    }

    @Override
    public Customer setIdCustomer(int typeId, String name, String birthday, int gender, String idCard, String phone, String email, String address) {
        return customerRepo.setIdUser(typeId,name,birthday,gender,idCard,phone,email,address);
    }

    @Override
    public Customer selectCustomer(int id) {
        return customerRepo.selectCustomer(id);
    }

    @Override
    public List<Customer> selectAllCustomers() {
         return customerRepo.selectAllCustomers();

    }

    @Override
    public boolean insertCustomer(Customer customer) throws SQLException {
        return customerRepo.insertCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return customerRepo.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return customerRepo.updateCustomer(customer);
    }

    @Override
    public Customer accountCustomer(String name, String email, String country) {
        return customerRepo.accountCustomer(name,email,country);
    }

    @Override
    public Customer getById(int id) {
        return customerRepo.getById(id);
    }

    @Override
    public List<Customer> searByName(String name) {
        return customerRepo.searByName(name);
    }

    @Override
    public List<Customer> sortListCustomer(String name) {
        return customerRepo.sortListCustomer(name);
    }
}
