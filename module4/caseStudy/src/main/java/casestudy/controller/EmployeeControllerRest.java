package casestudy.controller;

import casestudy.entity.customer.Customer;
import casestudy.entity.employee.Employee;
import casestudy.service.employee.impl.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeControllerRest {
    @Autowired
    private IEmployeeService iEmployeeService;

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Long id){
        Optional<Employee> employeeOptional = iEmployeeService.findById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iEmployeeService.remove(id);
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.NO_CONTENT);
    }
//    @GetMapping("/employee/search")
//    public ResponseEntity<List<Employee>> search(String name, Pageable pageable){
//        List<Employee> employees = (List<Employee>) iEmployeeService.findAllByNameContaining(name,pageable);
//        return new ResponseEntity<>(employees, HttpStatus.OK);
//    }

    @GetMapping("employee/search/{search}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> searchCustomer(@PathVariable("search") String name, Pageable pageable) {
        if (name == null){
            name = "";
        }
        if (name.equals("")){
            return  iEmployeeService.findAllAPI(pageable);
        }
        return iEmployeeService.findAllByNameContaining(name,pageable);
    }
}
