package casestudy.service.employee.impl;

import casestudy.entity.employee.Employee;
import casestudy.entity.employee.Position;

import java.util.Optional;

public interface IPositionService {
    Iterable<Position> findAll();
    Optional<Position> findById(Long id);
}
