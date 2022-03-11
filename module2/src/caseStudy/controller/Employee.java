package caseStudy.controller;

import java.util.Date;

public class Employee extends Person{
    private String IDEmployee;
    private String level;
    private String position;

    public Employee() {
    }

    public Employee(String name, Date date, int IDCard, int phoneNumber, String email, String gender, String IDEmployee, String level, String position) {
        super(name, date, IDCard, phoneNumber, email, gender);
        this.IDEmployee = IDEmployee;
        this.level = level;
        this.position = position;
    }

    public String getIDEmployee() {
        return IDEmployee;
    }

    public void setIDEmployee(String IDEmployee) {
        this.IDEmployee = IDEmployee;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
