package module6.backend.service.Impl;


import module6.backend.entity.ClassDTO.EmployeeAccount;
import module6.backend.entity.account.Account;
import module6.backend.entity.account.Role;
import module6.backend.entity.employee.Employee;

import module6.backend.repository.IAccountRepository;
import module6.backend.repository.IEmployeeRepository;
import module6.backend.repository.IRoleRepository;
import module6.backend.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public List<Account> findAllAccount() {
        return accountRepository.findAllAccount();
    }

    @Override
    public Optional<Account> findAccountById(Long id) {
        return accountRepository.findAccountById(id);
    }

    @Override
    public void updatePassword(String password, Long id) {
        accountRepository.updatePassword(password, id);
    }


    //Nhi VP code them san 2 acc admin
    @Override
    public void initRoleAndAccount() {
        Role adminRole = roleRepository.findRoleByRoleName("ROLE_ADMIN");
        Role accountantRole = roleRepository.findRoleByRoleName("ROLE_ACCOUNTANT");
        Role sellRole = roleRepository.findRoleByRoleName("ROLE_SELL");
        if (accountRepository.findAccountByUsername("admin") == null) {
            Account adminUser = new Account();
            adminUser.setUsername("admin");
            adminUser.setPassword(getEncodedPassword("123123"));
            adminUser.setAccountFlag(false);
            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(adminRole);
            adminUser.setRoles(adminRoles);
            accountRepository.save(adminUser);
        }
        if (accountRepository.findAccountByUsername("admin1") == null) {
            Account adminUser1 = new Account();
            adminUser1.setUsername("admin1");
            adminUser1.setPassword(getEncodedPassword("123123"));
            adminUser1.setAccountFlag(false);
            Set<Role> adminRoles1 = new HashSet<>();
            adminRoles1.add(adminRole);
            adminUser1.setRoles(adminRoles1);
            accountRepository.save(adminUser1);
        }
    }


    //NhiVP code tao account va employee
    @Override
    public void createEmployeeAccount(EmployeeAccount employeeAccount) {
        if (employeeRepository.findExistEmployeeDontHasAccount(employeeAccount.getEmployee().getEmployeeCode()) != null) {
            Set<Role> roles = new HashSet<>();
            Role role = roleRepository.findById(employeeAccount.getEmployee().getEmployeePositionId().getPositionId()).get();
            Employee employee = employeeRepository.findEmployeeByCode(employeeAccount.getEmployee().getEmployeeCode());
            roles.add(role);
            Account account = employeeAccount.getAccount();
            account.setRoles(roles);
            account.setPassword(getEncodedPassword(employeeAccount.getAccount().getPassword()));
            employee.setEmployeeAccountId(account);
            employeeRepository.save(employee);
        } else {
            Set<Role> roles = new HashSet<>();
            employeeRepository.save(employeeAccount.getEmployee());
            Role role = roleRepository.findById(employeeAccount.getEmployee().getEmployeePositionId().getPositionId()).get();
            roles.add(role);
            Account account = employeeAccount.getAccount();
            account.setRoles(roles);
            account.setPassword(getEncodedPassword(employeeAccount.getAccount().getPassword()));
            employeeAccount.getEmployee().setEmployeeAccountId(account);
            employeeRepository.save(employeeAccount.getEmployee());
        }
    }

    @Override
    public List<String> findAllUsername() {
        return accountRepository.findAllUsername();
    }

    @Override
    public Account findAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
