package casestudy.service.employee.impl;

import casestudy.entity.employee.EducationDegree;
import casestudy.entity.employee.Employee;

import java.util.Optional;

public interface IEducationService {
    Iterable<EducationDegree> findAll();
    Optional<EducationDegree> findById(Long id);
}
