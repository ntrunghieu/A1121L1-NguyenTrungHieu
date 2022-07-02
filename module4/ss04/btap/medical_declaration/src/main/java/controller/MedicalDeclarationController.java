package controller;

import entity.MedicalDeclaration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalDeclarationController {
    @GetMapping(value = "/create")
    public String goMedicalDeclarationForm(Model model){
        model.addAttribute("medical", new MedicalDeclaration());
        return "home";
    }

    @PostMapping(value = "/create")
    public String sendForm(@ModelAttribute MedicalDeclaration medicalDeclaration,
                           Model model){
        model.addAttribute("medical",medicalDeclaration);
        return "home";
    }
}
