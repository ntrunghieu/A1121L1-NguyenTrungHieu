package module6.backend.entity.employee;

import javax.persistence.*;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long positionId;
    private String positionName;
    private Boolean positionFlag = false;

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
