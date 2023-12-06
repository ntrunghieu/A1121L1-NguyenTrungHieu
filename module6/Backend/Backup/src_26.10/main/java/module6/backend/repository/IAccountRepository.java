package module6.backend.repository;
import module6.backend.entity.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import java.util.List;


@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "select * from account where account_flag = 0 ", nativeQuery = true)
    List<Account> findAllAccount();

    @Query(value = "SELECT * FROM account WHERE account_id = :id AND account_flag = 0", nativeQuery = true)
    Optional<Account> findAccountById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE account SET password = :password WHERE account_id = :id", nativeQuery = true)
    void updatePassword(@Param("password") String password, @Param("id") Long id);

    @Query(value = "SELECT * FROM account WHERE username=?1 and account_flag = 0", nativeQuery = true)
    Account findAccountByUsername(String username);

    @Query(value = "SELECT username FROM account WHERE username=?1 and account_flag = 0", nativeQuery = true)
    String findUsername(String username);

    @Query(value = "INSERT INTO account(username,password) values (?1,?2)", nativeQuery = true)
    void saveAccount(String username, String password);

    @Query(value = "select username from account where account_flag = 0", nativeQuery = true)
    List<String> findAllUsername();
}
