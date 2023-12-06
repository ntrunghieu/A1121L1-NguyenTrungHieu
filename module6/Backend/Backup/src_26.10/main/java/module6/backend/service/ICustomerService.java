package module6.backend.service;
import module6.backend.entity.Import;
import module6.backend.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface ICustomerService {

    Customer getCustomerByCode(String codeCustomer);

    List<Customer> getAllCustomer();

    List<Customer> getAllCustomerWithPagination(int index);

    Page<Customer> findAllCustomer1(Pageable page);

    void deleteCustomerById(Long id1, Long id2);

    List<Customer> searchCustomerByNameAndPhone(String name, String phone);

    Page<Customer> searchCustomer(String name, String phone, Pageable page);

    Page<Customer> searchCustomerName(String name, Pageable page);

    Optional<Customer> findCustomerById(Long id);

    void updateCustomer(String name, String code, String avatar, String address, String phone, String email, Long typeId, Long id);

    void createCustomer(String name, String code, String avt, String address, String phone, String email, Long customerType);

}
