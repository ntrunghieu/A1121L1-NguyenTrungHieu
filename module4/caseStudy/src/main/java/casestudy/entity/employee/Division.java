package casestudy.entity.employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "division")
public class Division {
    @Column(name = "division_id")
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long divisionId;

    @Column(name = "division_name")
    private String divisionName;

    @OneToMany(targetEntity = Employee.class)
    private List<Employee> employees;

    public Division() {
    }

    public Division(Long divisionId, String divisionName, List<Employee> employees) {
        this.divisionId = divisionId;
        this.divisionName = divisionName;
        this.employees = employees;
    }

    public Long getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Long divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
