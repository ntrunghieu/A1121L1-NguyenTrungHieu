package service.impl;

import entity.Product;
import org.springframework.stereotype.Service;
import service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Banh oreo", 2, "loai 500g"));
        products.put(2, new Product(2, "keo gung", 3, "mau xanh"));
        products.put(3, new Product(3, "dua hau", 5, "5kg"));
        products.put(4, new Product(4, "nhan", 2, "3kg"));
        products.put(5, new Product(5, "soda", 1, "mau do"));
        products.put(6, new Product(6, "coca-cola", 3, "s"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public Product findByName(String name) {
//        List<Product> productListSearch = new ArrayList<>();
        for (Product product: products.values()) {
            if (product.getName().equalsIgnoreCase(name)){
                return product;
            }
        }
        return null;

    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
