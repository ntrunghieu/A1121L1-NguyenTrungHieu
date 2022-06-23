package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.IConvertMoney;


@Controller
public class ConvertMoney {
    @GetMapping("/form")
    public String redirectIndexPage() {
        return "home";
    }

    @PostMapping("/calculate")
    public ModelAndView convertMoney(@RequestParam String vnd, String exchangeRate) {
        ModelAndView modelAndView = new ModelAndView("home");
        double VND = Double.parseDouble(vnd);
        double rate = Double.parseDouble(exchangeRate);
        double usd = VND/rate;
        modelAndView.addObject("usd", usd);
        return modelAndView;
    }
}
