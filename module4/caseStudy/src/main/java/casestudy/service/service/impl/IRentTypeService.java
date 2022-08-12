package casestudy.service.service.impl;

import casestudy.entity.employee.Division;
import casestudy.entity.employee.Employee;
import casestudy.entity.service.RentType;
import casestudy.entity.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IRentTypeService {
    List<RentType> findAll1();

    Iterable<RentType> findAll();
    Optional<RentType> findById(Long id);
}
