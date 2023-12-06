package module6.backend.controller;

import module6.backend.entity.account.Account;
import module6.backend.entity.employee.Employee;
import module6.backend.entity.employee.Position;
import module6.backend.service.IAccountService;
import module6.backend.service.IEmployeeService;
import module6.backend.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IPositionService positionService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SELL')")
    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employeeList = this.employeeService.getAllEmployee();
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SELL')")
    @GetMapping("/employee-pagination/{index}")
    public ResponseEntity<Iterable<Employee>> getAllEmployeeWithPagination(@PathVariable("index") int index) {
        List<Employee> employees = (List<Employee>) employeeService.getAllEmployeeWithPagination(index);
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SELL')")
    @DeleteMapping("/employee-delete/{id}")
    public ResponseEntity<Employee> deleteCustomerById(@PathVariable("id") Long id) {
        Optional<Employee> employeeOptional = employeeService.findEmployeeById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.deleteEmployeeById(-id, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SELL')")
    //  SonLH  Tìm kiếm nhân viên theo id
    @GetMapping("/detail/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Long id) {
        Optional<Employee> employeeOptional = employeeService.findEmployeeById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SELL')")
    //  SonLH  lấy danh sách account
    @GetMapping("/account")
    public ResponseEntity<List<Account>> findAllAccount() {
        List<Account> accounts = accountService.findAllAccount();
        if (accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SELL')")
    //  SonLH  lấy danh sách chức vụ nhân viên
    @GetMapping("/position")
    public ResponseEntity<List<Position>> findAllPosition() {
        List<Position> positions = positionService.findAllPosition();
        if (positions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(positions, HttpStatus.OK);
    }

    //    AnDVH cập nhật nhân viên
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ACCOUNTANT', 'ROLE_SELL')")
    @PatchMapping("update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") Long id, @Valid @RequestBody Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<Employee> foundEmployee = employeeService.findEmployeeById(id);
        if (!foundEmployee.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            employeeService.updateEmployee(employee.getEmployeeName(), employee.getEmployeeAvatar(), employee.getEmployeeDateOfBirth(), employee.getEmployeeGender(), employee.getEmployeeAddress(), employee.getEmployeePhone(), id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SELL')")
    //NhiVP lấy nhân viên theo code
    @GetMapping("/byCode/{code}")
    public ResponseEntity<Employee> getEmployeeByCode(@PathVariable String code) {
        Employee employee = employeeService.findEmployeeByCode(code);
        if (employee == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    //NhiVP lấy danh sách mã nhân viên đã có tài khoản
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SELL')")
    @GetMapping("/listHasAccount")
    public ResponseEntity<List<String>> findAllEmployeeHasAccount() {
        List<String> employees = employeeService.findAllEmployeeHasAccount();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    //NhiVP lấy danh sách mã nhân viên chưa có tài khoản
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SELL')")
    @GetMapping("/listDontHasAccount")
    public ResponseEntity<List<String>> findAllEmployeeDontHasAccount() {
        List<String> employees = employeeService.findAllEmployeeDontHasAccount();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    //NhiVP lấy danh sách chức vụ trừ chức vụ quản lý
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SELL')")
    @GetMapping("/position-NotManager/list")
    public ResponseEntity<List<Position>> getPositionNotManager() {
        List<Position> positions = positionService.findPositionNotManager();
        if (positions.isEmpty()) {
            return new ResponseEntity<List<Position>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Position>>(positions, HttpStatus.OK);
    }

    @PatchMapping("update/{id}  ")
    public ResponseEntity<?> adminUpdateEmployee(@PathVariable("id") Long id,@RequestBody @Valid Employee employee,BindingResult bindingResult) {
        System.out.println(employee.getEmployeeCode());
        employeeService.adminUpdateEmployee(employee.getEmployeeName(),employee.getEmployeeCode(), employee.getEmployeeAvatar(), employee.getEmployeeDateOfBirth(), employee.getEmployeeGender(), employee.getEmployeeAddress(), employee.getEmployeePhone(), employee.getEmployeeSalary(),employee.getEmployeePositionId().getPositionId() ,id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> createEmployee(@RequestBody @Valid Employee employee, BindingResult bindingResult) {
        //tạo mới nhân viên
        try {
            System.out.println(employee.getEmployeeCode());
            employeeService.saveEmployee(employee.getEmployeeCode(), employee.getEmployeeName(), employee.getEmployeeAvatar(), employee.getEmployeeDateOfBirth(), employee.getEmployeeGender(), employee.getEmployeeAddress(), employee.getEmployeePhone(), employee.getEmployeeSalary(), employee.getEmployeePositionId().getPositionId());
            return new ResponseEntity<>(employee, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(employee, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("position/list")
    public ResponseEntity<List<Position>> getAllPosition() {
        List<Position> positions = employeeService.getAllPosition();
        return new ResponseEntity<>(positions, HttpStatus.OK);
    }
}
