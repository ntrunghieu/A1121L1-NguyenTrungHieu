package casestudy.repository.customer;

import casestudy.entity.customer.Customer;
import casestudy.entity.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Long> {
}
