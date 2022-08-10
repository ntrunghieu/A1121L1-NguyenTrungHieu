package casestudy.service.employee;

import casestudy.entity.employee.Division;
import casestudy.entity.employee.Employee;
import casestudy.repository.employee.IDivisionRepository;
import casestudy.service.employee.impl.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository iDivisionRepository;

    @Override
    public Iterable<Division> findAll() {
        return iDivisionRepository.findAll();
    }

    @Override
    public Optional<Division> findById(Long id) {
        return iDivisionRepository.findById(id);
    }
}
