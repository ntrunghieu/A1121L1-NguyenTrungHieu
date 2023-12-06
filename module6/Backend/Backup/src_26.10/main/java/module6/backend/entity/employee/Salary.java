package module6.backend.entity.employee;

import javax.persistence.*;

@Entity
@Table(name = "salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salaryId;
    private Double SalaryAdvancePayment = 0.0;
    private Boolean salaryFlag = false;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salary_employee_id")
    private Employee salaryEmployeeId;

    public Salary() {
    }

    public Salary(Long salaryId, Double salaryAdvancePayment, Boolean salaryFlag, Employee salaryEmployeeId) {
        this.salaryId = salaryId;
        SalaryAdvancePayment = salaryAdvancePayment;
        this.salaryFlag = salaryFlag;
        this.salaryEmployeeId = salaryEmployeeId;
    }

    public Long getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Long salaryId) {
        this.salaryId = salaryId;
    }

    public Double getSalaryAdvancePayment() {
        return SalaryAdvancePayment;
    }

    public void setSalaryAdvancePayment(Double salaryAdvancePayment) {
        SalaryAdvancePayment = salaryAdvancePayment;
    }

    public Boolean getSalaryFlag() {
        return salaryFlag;
    }

    public void setSalaryFlag(Boolean salaryFlag) {
        this.salaryFlag = salaryFlag;
    }

    public Employee getSalaryEmployeeId() {
        return salaryEmployeeId;
    }

    public void setSalaryEmployeeId(Employee salaryEmployeeId) {
        this.salaryEmployeeId = salaryEmployeeId;
    }
}
