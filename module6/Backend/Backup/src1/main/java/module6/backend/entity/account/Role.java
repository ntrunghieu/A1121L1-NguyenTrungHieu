package module6.backend.entity.account;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    private String roleName;
    private Boolean roleFlag = false;

    public Role() {
    }

    public Role(Long roleId, String roleName, Boolean roleFlag) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleFlag = roleFlag;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Boolean getRoleFlag() {
        return roleFlag;
    }

    public void setRoleFlag(Boolean roleFlag) {
        this.roleFlag = roleFlag;
    }
}
