package module6.backend.entity.employee;

import module6.backend.entity.account.Account;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeCode;
    private String employeeName;
    private String employeeAvatar;
    private LocalDate employeeDateOfBirth;
    private String employeeGender;
    private String employeeAddress;
    private String employeePhone;
    private Double employeeSalary;
    private Boolean employeeFlag = false;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_account_id")
    private Account employeeAccountId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_position_id")
    private Position employeePositionId;

    public Employee() {
    }

    public Employee(Long employeeId, String employeeCode, String employeeName, String employeeAvatar, LocalDate employeeDateOfBirth, String employeeGender, String employeeAddress, String employeePhone, Double employeeSalary, Boolean employeeFlag, Account employeeAccountId, Position employeePositionId) {
        this.employeeId = employeeId;
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.employeeAvatar = employeeAvatar;
        this.employeeDateOfBirth = employeeDateOfBirth;
        this.employeeGender = employeeGender;
        this.employeeAddress = employeeAddress;
        this.employeePhone = employeePhone;
        this.employeeSalary = employeeSalary;
        this.employeeFlag = employeeFlag;
        this.employeeAccountId = employeeAccountId;
        this.employeePositionId = employeePositionId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAvatar() {
        return employeeAvatar;
    }

    public void setEmployeeAvatar(String employeeAvatar) {
        this.employeeAvatar = employeeAvatar;
    }

    public LocalDate getEmployeeDateOfBirth() {
        return employeeDateOfBirth;
    }

    public void setEmployeeDateOfBirth(LocalDate employeeDateOfBirth) {
        this.employeeDateOfBirth = employeeDateOfBirth;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public Boolean getEmployeeFlag() {
        return employeeFlag;
    }

    public void setEmployeeFlag(Boolean employeeFlag) {
        this.employeeFlag = employeeFlag;
    }

    public Account getEmployeeAccountId() {
        return employeeAccountId;
    }

    public void setEmployeeAccountId(Account employeeAccountId) {
        this.employeeAccountId = employeeAccountId;
    }

    public Position getEmployeePositionId() {
        return employeePositionId;
    }

    public void setEmployeePositionId(Position employeePositionId) {
        this.employeePositionId = employeePositionId;
    }
}
