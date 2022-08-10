package springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import springboot.entity.Counter;

//@Controller
//@SessionAttributes("counter")
//public class CounterController {
//
//    @ModelAttribute("counter")
//    public Counter setUpCounter() {
//        return new Counter();
//    }
//
//    @GetMapping("/")
//    public String get(@ModelAttribute("counter") Counter counter) {
//        counter.increment();
//        return "/index";
//    }
//}
