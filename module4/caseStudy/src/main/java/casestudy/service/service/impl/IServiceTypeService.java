package casestudy.service.service.impl;

import casestudy.entity.employee.EducationDegree;
import casestudy.entity.service.ServiceType;

import java.util.List;
import java.util.Optional;

public interface IServiceTypeService {
    List<ServiceType> findAll1();
    Iterable<ServiceType> findAll();
    Optional<ServiceType> findById(Long id);

}
