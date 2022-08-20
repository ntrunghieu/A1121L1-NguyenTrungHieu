package exam.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TinTucController {
    @GetMapping({"/list","/"})
    public String getCustomerList(){
        return "/customer/list";
    }
}
