package module6.backend.service.Impl;

import module6.backend.entity.Import;
import module6.backend.entity.customer.Customer;
import module6.backend.repository.ICustomerRepository;
import module6.backend.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Customer getCustomerByCode(String codeCustomer) {
        return customerRepository.getCustomerByCode(codeCustomer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }

    @Override
    public List<Customer> getAllCustomerWithPagination(int index) {
        return customerRepository.getAllCustomerWithPagination(index);
    }

    @Override
    public Page<Customer> findAllCustomer1(Pageable page) {
        return customerRepository.findAllICustomer1(page);
    }

    @Override
    public void deleteCustomerById(Long id1, Long id2) {
        customerRepository.deleteCustomerById(id1, id2);
    }

    @Override
    public List<Customer> searchCustomerByNameAndPhone(String name, String phone) {
        return customerRepository.searchCustomerByNameAndPhone(name, phone);
    }

    @Override
    public Page<Customer> searchCustomer(String name, String phone, Pageable page) {
        return customerRepository.searchCustomer(name, phone, page);
    }

    @Override
    public Page<Customer> searchCustomerName(String name, Pageable page) {
        return customerRepository.searchCustomerName(name, page);

    }

    @Override
    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public void createCustomer(String name, String code, String avt, String address, String phone, String email, Long customerType) {
        customerRepository.createCustomer(name, code, avt, address, phone, email, customerType);
    }

    @Override
    public void updateCustomer(String name, String code, String avatar, String address, String phone, String email, Long typeId, Long id) {
        customerRepository.updateCustomer(name, code, avatar, address, phone, email, typeId, id);
    }

}
