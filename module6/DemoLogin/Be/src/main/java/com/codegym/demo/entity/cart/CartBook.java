//package com.codegym.demo.entity.cart;
//
//import com.codegym.demo.entity.book.Book;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "cart_book")
//public class CartBook {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long cartBookId;
//
//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "cart_id")
//    private Cart cartId;
//
//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "book_id")
//    private Book bookId;
//
//    public CartBook() {
//    }
//
//    public CartBook(Long cartBookId, Cart cartId, Book bookId) {
//        this.cartBookId = cartBookId;
//        this.cartId = cartId;
//        this.bookId = bookId;
//    }
//
//    public Long getCartBookId() {
//        return cartBookId;
//    }
//
//    public void setCartBookId(Long cartBookId) {
//        this.cartBookId = cartBookId;
//    }
//
//    public Cart getCartId() {
//        return cartId;
//    }
//
//    public void setCartId(Cart cartId) {
//        this.cartId = cartId;
//    }
//
//    public Book getBookId() {
//        return bookId;
//    }
//
//    public void setBookId(Book bookId) {
//        this.bookId = bookId;
//    }
//}
