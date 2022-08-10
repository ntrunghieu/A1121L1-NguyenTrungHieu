package casestudy.service.employee.impl;

import casestudy.entity.employee.Division;
import casestudy.entity.employee.Employee;

import java.util.Optional;

public interface IDivisionService {
    Iterable<Division> findAll();
    Optional<Division> findById(Long id);
}
