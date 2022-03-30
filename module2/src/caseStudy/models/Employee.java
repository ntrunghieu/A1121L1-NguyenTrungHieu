package caseStudy.models;

import java.util.Date;

public class Employee extends Person {
    private String IDEmployee;
    private String level;
    private String position;
    private int salary;

    public Employee() {
    }

    public Employee(String name, int IDCard, int phoneNumber, String email, String gender, String IDEmployee, String level, String position, int salary) {
        super(name, IDCard, phoneNumber, email, gender);
        this.IDEmployee = IDEmployee;
        this.level = level;
        this.position = position;
        this.salary = salary;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getPhone() {
        return phoneNumber;
    }
    public void setPhone(int phone) {
        this.phoneNumber = phone;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String toString() {
        return "Employee: " +
                "IDEmployee='" + IDEmployee + '\'' +
                ", level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", IDCard=" + IDCard +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'';
    }
}
