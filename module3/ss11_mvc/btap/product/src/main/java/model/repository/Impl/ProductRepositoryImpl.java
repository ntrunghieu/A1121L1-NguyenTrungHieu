package model.repository.Impl;

import model.bean.Product;
import model.repository.IProductRepository;

import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    private static List<Product> products;
    static {
        products.add(new Product(1,"Laptop",2000000,"mau xanh", "USA"));
        products.add(new Product(2,"Sneaker Nike Air Odeyssey",1000,"mau do, size 43", "VIETNAM"));
        products.add(new Product(3,"QUần skinny",15000,"mau xanh, size XL", "QUANG CHAU"));
        products.add(new Product(4,"Áo Polo",199000,"mau trang den, size LL", "VIETNAM"));
        products.add(new Product(5,"Dép tông lào",8000,"hua se ngoan", "VIETNAM"));

    }
    @Override
    public List<Product> listProduct() {
        return products;
    }

    @Override
    public void create(int id,Product product) {
         products.add(id,product);
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void remove(int id, Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (id == product.getId()){
                products.remove(i);
            }
        }
    }

    @Override
    public void searchByName(String name) {

    }
}
