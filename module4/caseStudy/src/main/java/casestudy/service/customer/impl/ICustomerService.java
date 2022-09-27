package casestudy.service.customer.impl;

import casestudy.entity.customer.Customer;
import casestudy.entity.customer.CustomerType;
import casestudy.entity.employee.Division;
import casestudy.entity.employee.EducationDegree;
import casestudy.entity.employee.Employee;
import casestudy.entity.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Iterable<Customer> findAll();

    Optional<Customer> findById(Long id);

    Customer save(Customer customer);

    void update(Customer customer);

    Customer findById1(Long id);

    void remove(Long id);

    boolean isCustomerExist(Long id) ;

    Iterable<Customer> findAllByCustomerType(CustomerType customerType);


    Page<Customer> findAll(Pageable pageable);
    List<Customer> findAllAPI(Pageable pageable);
//    Page<Customer> findAllByCustomerNameContaining(String name, Pageable pageable);
    List<Customer> findAllByCustomerNameContaining(String name, Pageable pageable);


//    getListCustomer co phan trang
    Page<Customer> getAllCustomerDTO(Pageable pageable);
    List<Customer> getAllCustomerDTONotPagination();


//    search name
    List<Customer> searchName(String name);
}
