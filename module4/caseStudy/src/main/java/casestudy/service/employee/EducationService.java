package casestudy.service.employee;

import casestudy.entity.employee.EducationDegree;
import casestudy.repository.employee.IEducationRepository;
import casestudy.service.employee.impl.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EducationService implements IEducationService {
    @Autowired
    private IEducationRepository iEducationRepository;

    @Override
    public Iterable<EducationDegree> findAll() {
        return iEducationRepository.findAll();
    }

    @Override
    public Optional<EducationDegree> findById(Long id) {
        return iEducationRepository.findById(id);
    }
}
