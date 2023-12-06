//package com.codegym.demo.entity.cart;

//import com.codegym.demo.entity.account.Account;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "cart")
//public class Cart {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long cartId;
//
//    private String cartCode;
//
//    private Integer cartTotalQuantity;
//
//    private Double cartTotalMoney;
//
//    private Boolean cartStatus;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "cart_account_id")
//    private Account cartAccountId;
//
//    public Cart() {
//    }
//
//    public Cart(Long cartId, String cartCode, Integer cartTotalQuantity, Double cartTotalMoney, Boolean cartStatus, Account cartAccountId) {
//        this.cartId = cartId;
//        this.cartCode = cartCode;
//        this.cartTotalQuantity = cartTotalQuantity;
//        this.cartTotalMoney = cartTotalMoney;
//        this.cartStatus = cartStatus;
//        this.cartAccountId = cartAccountId;
//    }
//
//    public Long getCartId() {
//        return cartId;
//    }
//
//    public void setCartId(Long cartId) {
//        this.cartId = cartId;
//    }
//
//    public String getCartCode() {
//        return cartCode;
//    }
//
//    public void setCartCode(String cartCode) {
//        this.cartCode = cartCode;
//    }
//
//    public Integer getCartTotalQuantity() {
//        return cartTotalQuantity;
//    }
//
//    public void setCartTotalQuantity(Integer cartTotalQuantity) {
//        this.cartTotalQuantity = cartTotalQuantity;
//    }
//
//    public Double getCartTotalMoney() {
//        return cartTotalMoney;
//    }
//
//    public void setCartTotalMoney(Double cartTotalMoney) {
//        this.cartTotalMoney = cartTotalMoney;
//    }
//
//    public Boolean getCartStatus() {
//        return cartStatus;
//    }
//
//    public void setCartStatus(Boolean cartStatus) {
//        this.cartStatus = cartStatus;
//    }
//
//    public Account getCartAccountId() {
//        return cartAccountId;
//    }
//
//    public void setCartAccountId(Account cartAccountId) {
//        this.cartAccountId = cartAccountId;
//    }
//}
