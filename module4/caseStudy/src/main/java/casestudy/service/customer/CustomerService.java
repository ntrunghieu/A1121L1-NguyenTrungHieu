package casestudy.service.customer;

import casestudy.entity.customer.Customer;
import casestudy.entity.customer.CustomerType;
import casestudy.repository.customer.ICustomerRepository;
import casestudy.repository.employee.IEmployeeRepository;
import casestudy.service.customer.impl.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerService implements ICustomerService {
    private ICustomerRepository iCustomerRepository;

    @Autowired
    public CustomerService(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }




    @Override
    public Iterable<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById1(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Iterable<Customer> findAllByCustomerType(CustomerType customerType) {
        return iCustomerRepository.findAllByCustomerType(customerType);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByCustomerNameContaining(String name, Pageable pageable) {
        return iCustomerRepository.findAllByCustomerNameContaining(name,pageable);
    }
}
