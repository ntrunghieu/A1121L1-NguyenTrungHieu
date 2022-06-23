package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {


    @GetMapping("/hello")
    public String getHello(){
        return "hello";
    }

    @PostMapping("/bye")
    public String bye(@RequestParam String something, Model model){
        model.addAttribute("name",something);
        return "hello";
    }


}
