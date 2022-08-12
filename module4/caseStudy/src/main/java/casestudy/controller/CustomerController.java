package casestudy.controller;

import casestudy.entity.customer.Customer;
import casestudy.entity.customer.CustomerType;
import casestudy.entity.employee.Division;
import casestudy.entity.employee.EducationDegree;
import casestudy.entity.employee.Employee;
import casestudy.entity.employee.Position;
import casestudy.service.customer.CustomerServiceType;
import casestudy.service.customer.impl.ICustomerService;
import casestudy.service.customer.impl.ICustomerServiceType;
import casestudy.valid.CustomerValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerServiceType iCustomerServiceType;

    @ModelAttribute("customerType")
    public Iterable<CustomerType> customerServiceTypes() {
        return iCustomerServiceType.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
//        Iterable<Province> provinces = provinceService.findAll();
        Customer customer = new Customer();
//        customer.setProvince(new Province());
//        modelAndView.addObject("provinces", provinces);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        CustomerValidate validate = new CustomerValidate();
        validate.validate(customer, bindingResult);
        ModelAndView modelAndView = new ModelAndView("customer/create");
        if (bindingResult.hasErrors()){

            return modelAndView;

       }

        iCustomerService.save(customer);
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("")
    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search, @PageableDefault(value = 3) Pageable pageable) {
        Page<Customer> customers;
        if (search.isPresent()) {
            customers = (Page<Customer>) iCustomerService.findAllByCustomerNameContaining(search.get(), pageable);
        } else {
            customers = iCustomerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Customer customer, Model model) {
        Iterable<CustomerType> customerTypes = iCustomerServiceType.findAll();
        model.addAttribute("customerTypes", customerTypes);
        model.addAttribute("customer", customer);
        return "customer/create";

    }

}
