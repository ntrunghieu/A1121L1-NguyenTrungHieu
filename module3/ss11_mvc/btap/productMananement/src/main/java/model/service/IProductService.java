package model.service;

import model.bean.Product;

import java.util.List;

public interface IProductService {
    List<Product> listProduct();
    void create(int id,Product product);
    void save( Product product);
    Product findById(int id);
    void update(int id,Product product);
    void remove( int id);
    void searchByName(String name);
    Product findByName(String name);
}
