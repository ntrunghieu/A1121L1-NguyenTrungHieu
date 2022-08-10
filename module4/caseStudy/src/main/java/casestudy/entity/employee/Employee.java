package casestudy.entity.employee;

import javax.persistence.*;


@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long IDEmployee;

    public String name;
    //    public Date date;
    public String IDCard;
    public String phoneNumber;
    public String email;
    public String gender;
    public String date;

    @ManyToOne
    @JoinColumn(name = "education_degree_id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    private int salary;



    public Employee() {
    }

    public Employee(Long IDEmployee, String name, String IDCard, String phoneNumber, String email, String gender, String date, EducationDegree educationDegree, Position position, Division division, int salary) {
        this.IDEmployee = IDEmployee;
        this.name = name;
        this.IDCard = IDCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.date = date;
        this.educationDegree = educationDegree;
        this.position = position;
        this.division = division;
        this.salary = salary;
    }

    public Long getIDEmployee() {
        return IDEmployee;
    }

    public void setIDEmployee(Long IDEmployee) {
        this.IDEmployee = IDEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
