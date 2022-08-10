package controller;


import entity.Customer;
import entity.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.customer.ICustomerService;
import service.province.IProvinceService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
        @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
//        Iterable<Province> provinces = provinceService.findAll();
        Customer customer = new Customer();
//        customer.setProvince(new Province());
//        modelAndView.addObject("provinces", provinces);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

//    @GetMapping("")
//    public ModelAndView listCustomers(@PageableDefault(value = 3) Pageable pageable){
//        Page<Customer> customers = customerService.findAll(pageable);
//        ModelAndView modelAndView = new ModelAndView("/customer/list");
//        modelAndView.addObject("customers", customers);
//        return modelAndView;
//    }
    @GetMapping("")
    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search,@PageableDefault(value = 3) Pageable pageable){
        Page<Customer> customers;
        if(search.isPresent()){
            customers = customerService.findAllByFirstNameContaining(search.get(), pageable);
        } else {
            customers = customerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

//    @GetMapping("")
//    public String getHome(Model model){
//        Iterable<Customer> customers= customerService.findAll();
//        model.addAttribute("customers", customers);
//        return "customer/list";
//    }




//    public String saveCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
//        customerService.save(customer);
//
////        customerService.insertWithStoredProcedure(customer);
//        redirectAttributes.addFlashAttribute("message","Create new customer successfully!");
//        return "/customer/create";
//    }

//    @GetMapping("/{id}/edit")
//    public ModelAndView editForm(@PathVariable("id") Long id) {
//        Customer customer = customerService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("customer/edit","customer",customer);
//
//        return modelAndView;
//    }
//
//    @PostMapping("/edit")
//    public String editCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
//        customerService.save(customer);
////        redirectAttributes.addFlashAttribute("mess","Edit customer successfully!");
//        return "redirect:/home";
//    }
//
//    @GetMapping("/{id}/delete")
//    public ModelAndView deleteForm(@PathVariable("id") Long id){
//        Customer customer = customerService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("customer/delete","customer",customer);
//
//        return modelAndView;
//    }
//
//    @GetMapping("/delete")
//    public String deleteCustomer(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
//        customerService.remove(id);
////        redirectAttributes.addFlashAttribute("mess","Delete customer successfully!");
//        return "redirect:/home";
//    }
}
