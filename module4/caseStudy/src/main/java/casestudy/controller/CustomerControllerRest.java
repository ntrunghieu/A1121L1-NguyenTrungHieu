package casestudy.controller;

import casestudy.entity.customer.Customer;
import casestudy.entity.employee.Employee;
import casestudy.service.customer.impl.ICustomerService;
import casestudy.service.employee.impl.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerControllerRest {
    @Autowired
    private ICustomerService iCustomerService;

    @DeleteMapping("/api/delete/{id}")
    public ResponseEntity<Customer> delete(@PathVariable Long id) {
        Optional<Customer> employeeOptional = iCustomerService.findById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iCustomerService.remove(id);
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.NO_CONTENT);
    }

    //    @GetMapping("/customer/search/{search}")
//    public ResponseEntity<List<Customer>> search(@PathVariable String search, Pageable pageable){
//        List<Customer> customers = (List<Customer>) iCustomerService.findAllByCustomerNameContaining(search,pageable);
//        return new ResponseEntity<>(customers, HttpStatus.OK);
//    }
    @GetMapping("/customer/search/{search}")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> searchCustomer(@PathVariable("search") String name, Pageable pageable) {
//        if (name.equals("")){
//            return  iCustomerService.findAllAPI(pageable);
//        }
//        return iCustomerService.findAllByCustomerNameContaining(name,pageable);
//    }

        if (name == null) {
            name = "";
        }
        if (name.equals("")) {
            return iCustomerService.findAllAPI(pageable);
        }
        return iCustomerService.findAllByCustomerNameContaining(name, pageable);
    }
}
