package casestudy.controller;

import casestudy.entity.employee.Division;
import casestudy.entity.employee.EducationDegree;
import casestudy.entity.employee.Employee;
import casestudy.entity.employee.Position;
import casestudy.entity.service.RentType;
import casestudy.entity.service.Service;
import casestudy.entity.service.ServiceType;
import casestudy.service.employee.impl.IDivisionService;
import casestudy.service.employee.impl.IEducationService;
import casestudy.service.employee.impl.IEmployeeService;
import casestudy.service.employee.impl.IPositionService;
import casestudy.service.service.impl.IRentTypeService;
import casestudy.service.service.impl.IServiceService;
import casestudy.service.service.impl.IServiceTypeService;
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
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IRentTypeService rentTypeService;

    @Autowired
    private IServiceTypeService serviceTypeService;


    @ModelAttribute("rentTypes")
    public Iterable<RentType> rentTypes() {
        return rentTypeService.findAll();
    }

    @ModelAttribute("serviceTypes")
    public Iterable<ServiceType> serviceTypes() {
        return serviceTypeService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("service/create");
//        Iterable<Province> provinces = provinceService.findAll();
        Service service = new Service();
//        customer.setProvince(new Province());
//        modelAndView.addObject("provinces", provinces);
        modelAndView.addObject("service", service);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveCustomer(@Valid @ModelAttribute("service") Service service, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("service/create");
        if (!bindingResult.hasFieldErrors()) {
            serviceService.save(service);
            modelAndView.addObject("service", new Service());
            modelAndView.addObject("message", "New service created successfully");
        }
        return modelAndView;

//        serviceService.save(service);
//        ModelAndView modelAndView = new ModelAndView("service/create");
//        modelAndView.addObject("service", new Service());
//        modelAndView.addObject("message", "New service created successfully");
//        return modelAndView;
    }

    @GetMapping("")
    public ModelAndView listServices(@RequestParam("search") Optional<String> search, @PageableDefault(value = 3) Pageable pageable) {
        Page<Service> services;
        if (search.isPresent()) {
            services = (Page<Service>) serviceService.findAllByServiceNameContaining(search.get(), pageable);
        } else {
            services = serviceService.findAll(pageable);
        }

        ModelAndView modelAndView = new ModelAndView("service/list");
        modelAndView.addObject("services", services);
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Service service, Model model) {
        Iterable<RentType> rentTypes = rentTypeService.findAll();
        Iterable<ServiceType> serviceTypes = serviceTypeService.findAll();

        model.addAttribute("rentTypes", rentTypes);
        model.addAttribute("serviceTypes", serviceTypes);
        model.addAttribute("service", service);
        return "service/create";

    }
}
