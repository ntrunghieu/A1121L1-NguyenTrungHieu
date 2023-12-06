package module6.backend.service.Impl;

import module6.backend.repository.ISalaryRepository;
import module6.backend.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryServiceImpl implements ISalaryService {
    @Autowired
    private ISalaryRepository salaryRepository;
}
