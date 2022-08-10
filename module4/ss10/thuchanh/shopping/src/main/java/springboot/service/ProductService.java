package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.entity.Product;
import springboot.repository.IProductRepository;

import java.util.Optional;
@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;


    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
