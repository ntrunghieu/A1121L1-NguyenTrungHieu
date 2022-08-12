package casestudy.repository.customer;

import casestudy.entity.customer.Customer;
import casestudy.entity.customer.CustomerType;
import casestudy.entity.employee.Division;
import casestudy.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Iterable<Customer> findAllByCustomerType(CustomerType customerType);
//    Page<Customer> findAllByCustomerNameContaining(String name, Pageable pageable);
    List<Customer> findAllByCustomerNameContaining(String name, Pageable pageable);


}
