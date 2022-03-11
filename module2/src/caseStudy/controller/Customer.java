package caseStudy.controller;

import java.util.Date;

public class Customer extends Person{
    private String IDCustomer;
    private String typeCustomer;
    private String address;


    public Customer() {};

    public Customer(String name, Date date, int IDCard, int phoneNumber, String email, String gender, String ID, String typeCustomer, String address) {
        super(name, date, IDCard, phoneNumber, email, gender);
        this.IDCustomer = ID;
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getIDCustomer() {
        return IDCustomer;
    }

    public void setIDCustomer(String IDCustomer) {
        this.IDCustomer = IDCustomer;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
