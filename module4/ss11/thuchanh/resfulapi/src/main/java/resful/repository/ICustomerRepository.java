package resful.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import resful.entity.Customer;
@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
