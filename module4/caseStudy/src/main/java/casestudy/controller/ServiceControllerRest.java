package casestudy.controller;

import casestudy.entity.customer.Customer;
import casestudy.entity.employee.Employee;
import casestudy.entity.service.Service;
import casestudy.service.employee.impl.IEmployeeService;
import casestudy.service.service.impl.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class ServiceControllerRest {
    @Autowired
    private IServiceService iServiceService;

    @DeleteMapping("service/delete/{id}")
    public ResponseEntity<Service> delete(@PathVariable Long id){
        Optional<Service> employeeOptional = iServiceService.findById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iServiceService.delete(id);
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.NO_CONTENT);
    }
    @GetMapping("/service/search")
    public ResponseEntity<List<Service>> search(String name, Pageable pageable){
        List<Service> employees = (List<Service>) iServiceService.findAllByServiceNameContaining(name,pageable);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("service/search/{search}")
    @ResponseStatus(HttpStatus.OK)
    public List<Service> searchCustomer(@PathVariable("search") String name, Pageable pageable) {
        if (name == null){
            name = "";
        }
        if (name.equals("")){
            return  iServiceService.findAllAPI(pageable);
        }
        return iServiceService.findAllByServiceNameContaining(name,pageable);
    }
}
