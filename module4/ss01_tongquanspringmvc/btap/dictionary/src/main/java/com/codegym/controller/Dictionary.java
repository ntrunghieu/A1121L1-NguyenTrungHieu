package com.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.IDictionaryService;
import service.impl.DictionaryServiceImpl;

@Controller
public class Dictionary {
    @Autowired
    private DictionaryServiceImpl dictionaryService;

    @GetMapping(value = "/")
    public String home(){
        return "home";
    }

    @PostMapping(value = "/translate")
    public String translate(@RequestParam String search,
                            Model model){
        model.addAttribute("result", dictionaryService.translate(search));
        return "home";
    }
}
