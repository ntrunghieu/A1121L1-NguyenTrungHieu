package module6.backend.service.Impl;

import module6.backend.repository.ICustomerRepository;
import module6.backend.repository.IEmployeeRepository;
import module6.backend.repository.IMaterialRepository;
import module6.backend.service.IStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticServiceImpl implements IStatisticService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private IMaterialRepository materialRepository;
}
