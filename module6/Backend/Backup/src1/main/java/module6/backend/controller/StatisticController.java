package module6.backend.controller;

import module6.backend.service.IStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("api/statistic")
public class StatisticController {
    @Autowired
    private IStatisticService statisticService;

}
