package com.codegym.demo.controller;

import com.codegym.demo.entity.book.Book;
import com.codegym.demo.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
//@CrossOrigin
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookRepository bookRepository;

//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public List<Book> getList() {
        return bookRepository.findAll();
    }

//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @PostMapping
    public ResponseEntity<Book> create(@RequestBody @Valid Book book) {
        Book saveBook = bookRepository.save(book);
        URI uri = URI.create("/customers" + saveBook.getBookId());

        return ResponseEntity.created(uri).body(saveBook);
    }

//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
//    @PutMapping("/{id}")
//    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody @Valid Book book) {
//        Optional<Book> book1 = bookRepository.findById(id);
//        book1.get().setBookName(book.getCustomerName());
//        book1.get().se(customer.getCustomerAddress());
//        customerRepository.save(customer1.get());
//        URI uri = URI.create("/customers/" + customer1.get().getCustomerId());
//
//        return ResponseEntity.created(uri).body(customer1.get());
//    }


}
