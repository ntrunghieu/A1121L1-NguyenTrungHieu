package casestudy.repository.service;

import casestudy.entity.employee.Employee;
import casestudy.entity.service.RentType;
import casestudy.entity.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IServiceRepository extends JpaRepository<Service, Long> {
    Page<Service> findAll(Pageable pageable);
//    Page<Service> findAllByServiceNameContaining(String name, Pageable pageable);
    List<Service> findAllByServiceNameContaining(String name, Pageable pageable);
}
