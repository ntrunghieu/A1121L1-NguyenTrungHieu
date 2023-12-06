package module6.backend.entity.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long positionId;
    private String positionName;
    private Boolean positionFlag = false;

    @OneToMany(mappedBy = "employeePositionId")
    @JsonBackReference
    private Set<Employee> employeeList;
    public Position() {
    }

    public Position(Long positionId, String positionName, Boolean positionFlag) {
        this.positionId = positionId;
        this.positionName = positionName;
        this.positionFlag = positionFlag;
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

    public Boolean getPositionFlag() {
        return positionFlag;
    }

    public void setPositionFlag(Boolean positionFlag) {
        this.positionFlag = positionFlag;
    }
}
