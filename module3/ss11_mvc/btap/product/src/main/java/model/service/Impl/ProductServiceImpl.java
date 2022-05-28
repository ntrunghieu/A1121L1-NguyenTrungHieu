package model.service.Impl;

import model.bean.Product;
import model.repository.IProductRepository;
import model.repository.Impl.ProductRepositoryImpl;
import model.service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    IProductRepository productRepository=new ProductRepositoryImpl();
    @Override
    public List<Product> listProduct() {
        return productRepository.listProduct();
    }

    @Override
    public void create(Product product) {

    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public void searchByName(String name) {

    }
}
