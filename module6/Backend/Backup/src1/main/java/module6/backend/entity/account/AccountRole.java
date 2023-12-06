package module6.backend.entity.account;

import javax.persistence.*;

@Entity
@Table(name = "account_role")
public class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountRoleId;
    private Boolean accountRoleFlag = false;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account accountId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role roleId;

    public AccountRole() {
    }

    public AccountRole(Long accountRoleId, Boolean accountRoleFlag, Account accountId, Role roleId) {
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

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }
}
