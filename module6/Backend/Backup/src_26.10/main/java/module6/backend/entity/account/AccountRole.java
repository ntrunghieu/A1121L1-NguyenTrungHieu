package module6.backend.entity.account;

import javax.persistence.*;

@Entity
@Table(name = "account_role")
public class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_role_id")
    private Long accountRoleId;
    @Column(name = "account_role_flag")
    private Boolean accountRoleFlag = false;

    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "role_id")
    private Long roleId;

    public AccountRole() {
    }

    public AccountRole(Long accountRoleId, Boolean accountRoleFlag, Long accountId, Long roleId) {
        this.accountRoleId = accountRoleId;
        this.accountRoleFlag = accountRoleFlag;
        this.accountId = accountId;
        this.roleId = roleId;
    }

    public Long getAccountRoleId() {
        return accountRoleId;
    }

    public void setAccountRoleId(Long accountRoleId) {
        this.accountRoleId = accountRoleId;
    }

    public Boolean getAccountRoleFlag() {
        return accountRoleFlag;
    }

    public void setAccountRoleFlag(Boolean accountRoleFlag) {
        this.accountRoleFlag = accountRoleFlag;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
