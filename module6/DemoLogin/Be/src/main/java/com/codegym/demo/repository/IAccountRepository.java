package com.codegym.demo.repository;

import com.example.demologin.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findAllByUsername(String userName);

    Account findAccountByUsername(String username);
    Account findAccountByAccountId(Long id);

}
