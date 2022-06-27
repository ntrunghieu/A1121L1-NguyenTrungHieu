package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/home")
    public String goHome(){
        return "home";
    }

    @PostMapping("result")
    public String result(@RequestParam("num1") double num1, @RequestParam("num2") double num2, String Submit, Model model){
        double sum=0;
        String mess=null;
        switch (Submit){
            case "cong":
                sum = num1 + num2;
                break;
            case "tru":
                sum = num1 - num2;
                break;
            case "nhan":
                sum = num1 * num2;
                break;
            case "chia":
                if (num2 == 0){
                    mess="khong chia duoc cho 0";
                }else {
                    sum = num1 / num2;
                }
                break;
        }
        model.addAttribute("mess",mess);
        model.addAttribute("sum",sum);
        return "home";
    }
}
