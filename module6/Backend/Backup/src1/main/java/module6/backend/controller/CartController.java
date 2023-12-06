package module6.backend.controller;

import module6.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("api/cart")
public class CartController {
    @Autowired
    private ICartService cartService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IMaterialService materialService;

    @Autowired
    private ICartStatusService cartStatusService;
}
