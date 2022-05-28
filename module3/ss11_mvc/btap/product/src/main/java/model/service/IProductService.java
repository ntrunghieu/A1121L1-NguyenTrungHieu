package model.service;

import model.bean.Product;

import java.util.List;

public interface IProductService {
    List<Product> listProduct();
    void create(Product product);
    Product findById(int id);
    void update(int id, Product product);
    void remove(int id);
    void searchByName(String name);
}
