package controller;

import entity.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailController {
        @GetMapping(value = "/create")
        public String goCreateEmail(Model model){
            model.addAttribute("email",new Email());
            return "create";
        }

        @PostMapping(value = "/save")
        public String createEmail(@ModelAttribute Email email, Model model){
            model.addAttribute("email", email);
            return "show";
        }
}
