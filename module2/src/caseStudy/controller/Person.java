package caseStudy.controller;

import java.util.Date;

public abstract class Person {
    public String name;
    public Date date;
    public int IDCard;
    public int phoneNumber;
    public String email;
    public String gender;

    public Person() {
    }

    public Person(String name, Date date, int IDCard, int phoneNumber, String email, String gender) {
        this.name = name;
        this.date = date;
        this.IDCard = IDCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIDCard() {
        return IDCard;
    }

    public void setIDCard(int IDCard) {
        this.IDCard = IDCard;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
