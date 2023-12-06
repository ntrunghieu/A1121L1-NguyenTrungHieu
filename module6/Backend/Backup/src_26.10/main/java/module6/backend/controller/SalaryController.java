package module6.backend.controller;

import module6.backend.service.IEmployeeService;
import module6.backend.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/salary")
public class SalaryController {
    @Autowired
    private ISalaryService salaryService;

    @Autowired
    private IEmployeeService employeeService;

}
