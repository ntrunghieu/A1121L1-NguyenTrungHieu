package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/home")
public class ControllerSandwich {

    @GetMapping("/home")
    public String getHome(){
        return "home";
    }


    @PostMapping("/result")
    public String getResult(@RequestParam("condiment") String[] condiment, Model model){
        String output="";
        for (String s: condiment) {
            output=output+s+" ";
        }
        model.addAttribute("output",output);

        return "home";
    }

}
