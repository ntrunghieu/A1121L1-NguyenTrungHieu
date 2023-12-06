package com.bookstoreonline.bookstore.security.utils;

import com.bookstoreonline.bookstore.dao.account.AccountRepository;
import com.bookstoreonline.bookstore.entity.account.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
​
import java.util.HashSet;
import java.util.Set;
​
@Service
public class JwtServiceImpl implements UserDetailsService {
​
    @Autowired
    private AccountRepository accountRepository;
​
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByUsername(username);
        if (account != null) {
            return new User(account.getUsername(),
                    account.getPassword(),
                    getAuthority(account));
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
​
    private Set getAuthority(Account account) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        account.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });
        return authorities;
    }
}
