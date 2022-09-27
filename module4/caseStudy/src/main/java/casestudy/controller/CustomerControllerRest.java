package casestudy.controller;

import casestudy.entity.customer.Customer;
import casestudy.entity.customer.CustomerType;
import casestudy.entity.employee.Employee;
import casestudy.service.customer.impl.ICustomerService;
import casestudy.service.customer.impl.ICustomerServiceType;
import casestudy.service.employee.impl.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CustomerControllerRest {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerServiceType iCustomerServiceType;


//    xoa khach hang
    @DeleteMapping("/api/customer/delete/{id}")
    public ResponseEntity<Customer> delete(@PathVariable Long id) {
        Optional<Customer> customerOptional = iCustomerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iCustomerService.remove(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
    }

//    lay danh sach khach hang
    @GetMapping("/api/customer")
    public ResponseEntity<List<Customer>> getListCus( Pageable pageable){
            List<Customer> customerList = (List<Customer>) this.iCustomerService.findAll();
            if (customerList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
//    lay danh sach loai khach hang
    @GetMapping("/api/customerType")
    public ResponseEntity<List<CustomerType>> getListCusType(Pageable pageable){
        List<CustomerType> customerTypeList = (List<CustomerType>) this.iCustomerServiceType.findAll();
        if (customerTypeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerTypeList, HttpStatus.OK);
    }
//    them moi khach hang
    @PostMapping(value = "/api/customer/create")
    public ResponseEntity<Object> createCustomer(@Validated @RequestBody Customer customer,
                                                       BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
        this.iCustomerService.save(customer);
        return new ResponseEntity<>("Customer is created successfully", HttpStatus.CREATED);
    }
//    tim khach hang theo id
    @GetMapping(value = "/api/customer/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        boolean isCustomerExist = iCustomerService.isCustomerExist(id);
        if (isCustomerExist){
            Customer customer = iCustomerService.findById1(id);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    chinh sua thong tin khach hang
    @PatchMapping(value = "/api/customer/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable  Long id, @RequestBody Customer customer){
        boolean isCustomerExist = iCustomerService.isCustomerExist(id);
        if (isCustomerExist){
            iCustomerService.update(customer);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }




    @GetMapping("/api/customer/search/{search}")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> searchCustomer(@PathVariable("search") String name) {
//        if (name.equals("")){
//            return  iCustomerService.findAllAPI(pageable);
//        }
//        return iCustomerService.findAllByCustomerNameContaining(name,pageable);
//    }

        if (name == null) {
            name = "";
        }
        if (name.equals("")) {
            return (List<Customer>) iCustomerService.findAll();
        }
        return iCustomerService.searchName(name);
    }



    /// get list phan trang
//    @GetMapping("/api/pagination/customer/{index}")
//    public ResponseEntity<Page<Customer>> getAllCustomer(@PathVariable("index") int index) {
//        Page<Customer> customers = iCustomerService.findAll(PageRequest.of(index,5));
//        if (customers.isEmpty()) {
//            return new ResponseEntity<Page<Customer>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<Page<Customer>>(customers, HttpStatus.OK);
//    }
    @GetMapping("/api/pagination/customer")
    public ResponseEntity<Page<Customer>> getAllCustomer(@PageableDefault(value = 5, sort = "customerId", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Customer> customers = iCustomerService.findAll(pageable);
        if (customers.isEmpty()) {
            return new ResponseEntity<Page<Customer>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Page<Customer>>(customers, HttpStatus.OK);
    }

    @GetMapping("/api/customers-not-pagination")
    public ResponseEntity<List<Customer>> getAllVaccineNotPagination() {
        List<Customer> customers = iCustomerService.getAllCustomerDTONotPagination();
        if (customers.isEmpty()) {
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }

}
