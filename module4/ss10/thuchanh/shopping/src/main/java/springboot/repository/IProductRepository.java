package springboot.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import springboot.entity.Product;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
}
