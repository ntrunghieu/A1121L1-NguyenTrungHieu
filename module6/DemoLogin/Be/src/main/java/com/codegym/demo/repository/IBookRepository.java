package com.codegym.demo.repository;


import com.codegym.demo.entity.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {

}
