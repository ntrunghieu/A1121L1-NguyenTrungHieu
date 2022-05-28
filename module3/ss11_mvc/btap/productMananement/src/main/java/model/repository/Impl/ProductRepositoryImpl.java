package model.repository.Impl;

import model.bean.Product;
import model.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    private static List<Product> products;
    static {
        products = new ArrayList<>();
        products.add(new Product(0,"Laptop",2000000,"mau xanh", "USA"));
        products.add(new Product(1,"Sneaker Nike Air Odeyssey",1000,"mau do, size 43", "VIETNAM"));
        products.add(new Product(2,"QUần skinny",15000,"mau xanh, size XL", "QUANG CHAU"));
        products.add(new Product(3,"Áo Polo",199000,"mau trang den, size LL", "VIETNAM"));
        products.add(new Product(4,"Dép tông lào",8000,"hua se ngoan", "VIETNAM"));

    }
    @Override
    public List<Product> listProduct() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void create(int id,Product product) {
        products.add(id,product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.set(id,product);
    }

    @Override
    public void remove( int id) {
        products.remove(id);
//        for (int i = 0; i < products.size(); i++) {
//            if (id == product.getId()){
//                products.remove(i);
//            }
//        }
    }

   

    @Override
    public void searchByName(String name) {

    }
}
