package model;

public class Student {
    private Integer id;
    private String name;
    private String dateOfBirth;
    private double mark;

    public Student(Integer id, String name, String dateOfBirth, double mark) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.mark = mark;
    }

    public Student() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
