package module6.backend.repository;

import module6.backend.entity.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Long> {
    @Query(value = "select * from customer_type where customer_type_flag = 0 ", nativeQuery = true)
    List<CustomerType> findAllCustomerType();
}

