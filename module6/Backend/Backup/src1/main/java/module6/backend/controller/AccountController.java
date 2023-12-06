package module6.backend.controller;


import module6.backend.service.IAccountRoleService;
import module6.backend.service.IAccountService;
import module6.backend.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
@RequestMapping("api/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IAccountRoleService accountRoleService;
    @Autowired
    private IEmployeeService employeeService;
}
