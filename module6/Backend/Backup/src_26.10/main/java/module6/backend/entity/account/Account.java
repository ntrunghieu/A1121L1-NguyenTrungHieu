package module6.backend.entity.account;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.Length;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @NotBlank
    @Length(max = 20, min = 5)
    @Pattern(regexp = "^[a-z0-9]{5,20}$")
    private String username;
    @NotBlank
    private String password;
    private Boolean accountFlag = false;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "account_role",
            joinColumns = {
                    @JoinColumn(name = "account_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id")
            }
    )
    @JsonBackReference
    private Set<Role> roles;
    public Account() {
    }

    public Account(Long accountId , String username , String password , Boolean accountFlag , Set<Role> roles) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.accountFlag = accountFlag;
        this.roles = roles;
    }

    public Account(String username , String password) {
        this.username = username;
        this.password = password;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
