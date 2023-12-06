package module6.backend.entity.account;
import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private String username;
    private String password;
    private Boolean accountFlag = false;

    public Account() {
    }

    public Account(Long accountId, String username, String password, Boolean accountFlag) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.accountFlag = accountFlag;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAccountFlag() {
        return accountFlag;
    }

    public void setAccountFlag(Boolean accountFlag) {
        this.accountFlag = accountFlag;
    }
}
