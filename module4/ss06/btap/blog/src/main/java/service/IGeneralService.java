package service;

import entity.Blog;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);

//    List<T> findAll();
//
//    T findById(Long id);
//
//    void save(T t);
//
//    void remove(Long id);
//
//    boolean insertWithStoredProcedure(T t) ;
//    void update(T t);
}
