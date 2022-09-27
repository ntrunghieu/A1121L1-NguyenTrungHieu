package casestudy.repository.customer;

import casestudy.entity.customer.Customer;
import casestudy.entity.customer.CustomerType;
import casestudy.entity.employee.Division;
import casestudy.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Iterable<Customer> findAllByCustomerType(CustomerType customerType);
//    Page<Customer> findAllByCustomerNameContaining(String name, Pageable pageable);
    List<Customer> findAllByCustomerNameContaining(String name, Pageable pageable);

    @Query("SELECT e FROM customers e ORDER BY e.customerName DESC")
    List<Customer> findAllByCustomerName();

//    @Query("SELECT c from customers c left join customerType t on c.customerType.customerTypeId = t.customerTypeId group by c.customerId ?1,5")
//    List<Customer> getAllCustomer(int index);

//    @Query(value = "select * from customer where customer.customerName = ?1", nativeQuery = true)
//    Customer searchName(String name);

    @Query("select c from customers c where c.customerName like %:name% ")
    List<Customer> searchName(@Param("name") String name);
}
