package controller;


import entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.ICustomerService;

import java.util.List;

@Controller
@RequestMapping("/home")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String getHome(Model model){
        List<Customer> customers= customerService.findAll();
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
//        customerService.save(customer);

        customerService.insertWithStoredProcedure(customer);
//        redirectAttributes.addFlashAttribute("mess","Create new customer successfully!");
        return "redirect:/home";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView editForm(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("customer/edit","customer",customer);

        return modelAndView;
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
//        redirectAttributes.addFlashAttribute("mess","Edit customer successfully!");
        return "redirect:/home";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView deleteForm(@PathVariable("id") Long id){
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("customer/delete","customer",customer);

        return modelAndView;
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        customerService.remove(id);
//        redirectAttributes.addFlashAttribute("mess","Delete customer successfully!");
        return "redirect:/home";
    }
}
