package com.bookstoreonline.bookstore.dao;

import com.bookstoreonline.bookstore.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    Page<Book> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
