package service;

import model.Customer;
import model.CustomerType;
import repository.CustomerRepository;
import repository.CustomerRepositoryImpl;
import validation.Validate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }
    public List<CustomerType> getAllCustomerType() {
        return customerRepository.getAllCustomerType();
    }
    @Override
    public Map<String, String> createNewCustomer(Customer customer) {

        Map<String, String> errorMap = new HashMap<>();
        if (Validate.regexId(customer.getName())){
            errorMap.put("name", "Name invalid.");
        }

        if ( Validate.regexEmail(customer.getAddress()) ){
            errorMap.put("address", "Address invalid.");
        }

        if (errorMap.isEmpty()){
            customerRepository.createNewCustomer(customer);
        }
        return errorMap;
    }




    @Override
    public void deleteCustomer(Customer customer) {

    }
}
