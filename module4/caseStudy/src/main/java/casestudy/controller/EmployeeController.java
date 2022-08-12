package casestudy.controller;

import casestudy.entity.employee.Division;
import casestudy.entity.employee.EducationDegree;
import casestudy.entity.employee.Employee;
import casestudy.entity.employee.Position;
import casestudy.service.employee.impl.IDivisionService;
import casestudy.service.employee.impl.IEducationService;
import casestudy.service.employee.impl.IEmployeeService;
import casestudy.service.employee.impl.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDivisionService iDivisionService;

    @Autowired
    private IPositionService iPositionService;

    @Autowired
    private IEducationService iEducationService;


    @ModelAttribute("divisions")
    public Iterable<Division> divisions(){
        return iDivisionService.findAll();
    }
    @ModelAttribute("educationDegrees")
    public Iterable<EducationDegree> educationDegrees(){
        return iEducationService.findAll();
    }
    @ModelAttribute("positions")
    public Iterable<Position> positions(){
        return iPositionService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("employee/create");
//        Iterable<Province> provinces = provinceService.findAll();
        Employee employee = new Employee();
//        customer.setProvince(new Province());
//        modelAndView.addObject("provinces", provinces);
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveCustomer(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("")
    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search, @PageableDefault(value = 3) Pageable pageable){
        Page<Employee> employees;
        if(search.isPresent()){
            employees = (Page<Employee>) employeeService.findAllByNameContaining(search.get(), pageable);
        } else {
            employees = employeeService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("employee/list");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Employee employee, Model model){
        Iterable<Position> positionList = iPositionService.findAll();
        Iterable<Division> divisionList = iDivisionService.findAll();
        Iterable<EducationDegree> educationList = iEducationService.findAll();
        model.addAttribute("positionList", positionList);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("educationList", educationList);
        model.addAttribute("employee", employee);
        return "employee/create";

//        Optional<Employee> listEmployee = employeeService.findById(id);
//        modelMap.addAttribute("employee", listEmployee.get());
//        Iterable<Position> positionList = iPositionService.findAll();
//        Iterable<Division> divisionList = iDivisionService.findAll();
//        Iterable<EducationDegree> educationList = iEducationService.findAll();
//        modelMap.addAttribute("listDivision", divisionList);
//        modelMap.addAttribute("listPosition", positionList);
//        modelMap.addAttribute("listEducation", educationList);
//        return "employee/create";
    }

}
