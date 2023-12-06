package com.bookstoreonline.bookstore.entity.account;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
​
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;
​
@Entity
@Getter
@Setter
@Table(name = "account")
public class Account implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @Column(unique = true)
    private String username;
    private String password;
​
    @ManyToMany
    @JoinTable(name = "account_role",
            joinColumns = {
                    @JoinColumn(name = "account_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id")
            }
    )
    private Set<Role> roles= new HashSet<>();
​
    public Account() {
    }
​
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
​
    public Long getAccountId() {
        return accountId;
    }
​
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
​
    @Override
    public String getUsername() {
        return this.username;
    }
​
    public void setUsername(String username) {
        this.username = username;
    }
​
    public String getPassword() {
        return password;
    }
​
    public void setPassword(String password) {
        this.password = password;
    }
​
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
​
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
​
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
​
    @Override
    public boolean isEnabled() {
        return true;
    }
​
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
​
        for (Role role: roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }
​
    public Set<Role> getRoles() {
        return roles;
    }
​
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
​
    public void addRole(Role role) {
        this.roles.add(role);
    }
}
