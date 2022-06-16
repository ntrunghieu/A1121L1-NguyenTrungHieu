package repository;

import model.Customer;
import model.CustomerType;

import java.util.List;

public interface CustomerRepository {

    List<Customer> getAll();
    List<CustomerType> getAllCustomerType();

    void createNewCustomer( Customer customer );

    void deleteCustomer( Customer customer );

}
