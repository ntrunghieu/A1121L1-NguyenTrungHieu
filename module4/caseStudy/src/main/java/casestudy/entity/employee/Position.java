package casestudy.entity.employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "position")
public class Position {
   @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
    private Long positionId;
    private String positionName;

    @OneToMany(targetEntity = Employee.class)
    private List<Employee> employees;

    public Position() {
    }

    public Position(Long positionId, String positionName) {
        this.positionId = positionId;
        this.positionName = positionName;
    }

    public Position(Long positionId, String positionName, List<Employee> employees) {
        this.positionId = positionId;
        this.positionName = positionName;
        this.employees = employees;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
