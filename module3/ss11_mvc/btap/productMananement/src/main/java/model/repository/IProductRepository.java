package model.repository;

import model.bean.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> listProduct();
    void save( Product product);
    void create(int id,Product product);
    Product findById(int id);
    void update( int id,Product product);
    void remove( int id);
    void searchByName(String name);
    Product findByName(String name);
}
