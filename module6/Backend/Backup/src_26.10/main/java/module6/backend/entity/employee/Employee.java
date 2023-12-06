package module6.backend.entity.employee;

import module6.backend.entity.account.Account;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class Employee implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeCode;
    @NotBlank
    @Length(max = 50)
    @Pattern(regexp = "^[A-ZÀ|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ|È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ|Ì|Í|Ị|Ỉ|Ĩ|Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ|Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ|Ỳ|Ý|Ỵ|Ỷ|Ỹ|Đ][a-zà|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ|è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ|ì|í|ị|ỉ|ĩ|ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ|ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ|ỳ|ý|ỵ|ỷ|ỹ]*([ ][A-ZÀ|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ|È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ|Ì|Í|Ị|Ỉ|Ĩ|Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ|Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ|Ỳ|Ý|Ỵ|Ỷ|Ỹ|Đ][a-zà|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ|è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ|ì|í|ị|ỉ|ĩ|ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ|ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ|ỳ|ý|ỵ|ỷ|ỹ]*)*$")
    @Length(max = 50)
    private String employeeName;
    private String employeeAvatar;
    @Column(columnDefinition = "DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate employeeDateOfBirth;
    private String employeeGender;
    @Length(max = 60)
    private String employeeAddress;
    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$")
    private String employeePhone;
    private Double employeeSalary;
    private Boolean employeeFlag = false;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_account_id")
    private Account employeeAccountId;
    @ManyToOne(cascade = CascadeType.MERGE)
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        LocalDate birthday = employee.getEmployeeDateOfBirth();
        int currentYear = LocalDate.now().getYear();

        int gap = currentYear - birthday.getYear();
        if (gap < 18) {
            try {
                throw new Exception("Age must be greater than 18");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
