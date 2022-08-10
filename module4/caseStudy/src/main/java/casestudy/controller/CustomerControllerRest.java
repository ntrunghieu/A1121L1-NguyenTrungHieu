package casestudy.controller;

import casestudy.entity.customer.Customer;
import casestudy.entity.employee.Employee;
import casestudy.service.customer.impl.ICustomerService;
import casestudy.service.employee.impl.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerControllerRest {
    @Autowired
    private ICustomerService iCustomerService;

    @DeleteMapping("api/delete/{id}")
    public ResponseEntity<Customer> delete(@PathVariable Long id){
        Optional<Customer> employeeOptional = iCustomerService.findById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iCustomerService.remove(id);
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.NO_CONTENT);
    }
    @GetMapping("/customer/search")
    public ResponseEntity<List<Customer>> search(String name, Pageable pageable){
        List<Customer> employees = (List<Customer>) iCustomerService.findAllByCustomerNameContaining(name,pageable);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
