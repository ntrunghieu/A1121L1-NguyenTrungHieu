package service;

import entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IGeneralService<T>{
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);

}
