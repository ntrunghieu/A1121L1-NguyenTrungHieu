package module6.backend.controller;

import module6.backend.service.ICustomerService;
import module6.backend.service.IMaterialService;
import module6.backend.service.IMaterialTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("api/material")
public class MaterialController {
    @Autowired
    private IMaterialService materialService;

    @Autowired
    private IMaterialTypeService materialTypeService;

    @Autowired
    private ICustomerService customerService;

}
