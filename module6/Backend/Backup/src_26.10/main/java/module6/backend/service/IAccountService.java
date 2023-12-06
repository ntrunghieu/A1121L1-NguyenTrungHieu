package module6.backend.service;

import module6.backend.entity.ClassDTO.EmployeeAccount;
import module6.backend.entity.account.Account;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    List<Account> findAllAccount();
    Optional<Account> findAccountById(@Param("id") Long id);
    void updatePassword(String password, Long id);

    //NhiVP code tim account by username
    Account findAccountByUsername(String username);
    String getEncodedPassword(String password);
    //NhiVP code tao san admin
    void initRoleAndAccount();
    //NhiVP code tao employee moi va account moi
    void createEmployeeAccount(EmployeeAccount employeeAccount);
    //NhiVP code lấy danh sách username theo chuỗi String
    List<String> findAllUsername();
}
