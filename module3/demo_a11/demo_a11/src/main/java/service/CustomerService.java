package service;

import model.Customer;
import model.CustomerType;

import java.util.List;
import java.util.Map;

public interface CustomerService {

    List<Customer> getAll();

    List<CustomerType> getAllCustomerType();

    Map<String, String> createNewCustomer(Customer customer );

    void deleteCustomer( Customer customer );

}
