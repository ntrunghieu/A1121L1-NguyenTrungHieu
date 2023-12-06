//package com.codegym.demo.entity.customer;
//
//import com.codegym.demo.entity.account.Account;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "customer")
//public class Customer {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long customerId;
//
//    private String customerName;
//
//    private String customerPhone;
//
//    private String customerEmail;
//
//    private String customerImage;
//
//    private String customerAddress;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_account_id")
//    private Account customerAccountId;
//
//    public Customer() {
//    }
//
//    public Customer(Long customerId, String customerName, String customerPhone, String customerEmail, String customerImage, String customerAddress, Account customerAccountId) {
//        this.customerId = customerId;
//        this.customerName = customerName;
//        this.customerPhone = customerPhone;
//        this.customerEmail = customerEmail;
//        this.customerImage = customerImage;
//        this.customerAddress = customerAddress;
//        this.customerAccountId = customerAccountId;
//    }
//
//    public Long getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(Long customerId) {
//        this.customerId = customerId;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
//    public String getCustomerPhone() {
//        return customerPhone;
//    }
//
//    public void setCustomerPhone(String customerPhone) {
//        this.customerPhone = customerPhone;
//    }
//
//    public String getCustomerEmail() {
//        return customerEmail;
//    }
//
//    public void setCustomerEmail(String customerEmail) {
//        this.customerEmail = customerEmail;
//    }
//
//    public String getCustomerImage() {
//        return customerImage;
//    }
//
//    public void setCustomerImage(String customerImage) {
//        this.customerImage = customerImage;
//    }
//
//    public String getCustomerAddress() {
//        return customerAddress;
//    }
//
//    public void setCustomerAddress(String customerAddress) {
//        this.customerAddress = customerAddress;
//    }
//
//    public Account getCustomerAccountId() {
//        return customerAccountId;
//    }
//
//    public void setCustomerAccountId(Account customerAccountId) {
//        this.customerAccountId = customerAccountId;
//    }
//}
