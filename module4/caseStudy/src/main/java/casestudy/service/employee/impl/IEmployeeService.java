package casestudy.service.employee.impl;

import casestudy.entity.customer.Customer;
import casestudy.entity.employee.Division;
import casestudy.entity.employee.EducationDegree;
import casestudy.entity.employee.Employee;
import casestudy.entity.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface IEmployeeService  {
    Iterable<Employee> findAll();

    Optional<Employee> findById(Long id);

    Employee save(Employee employee);

    Employee findById1(Long id);

    void remove(Long id);

    Iterable<Employee> findAllByEducationDegree(EducationDegree education);
    Iterable<Employee> findAllByPosition(Position position);
    Iterable<Employee> findAllByDivision(Division division);

    List<Employee> findAllAPI(Pageable pageable);
    Page<Employee> findAll(Pageable pageable);
    List<Employee> findAllByNameContaining(String name, Pageable pageable);
//    Page<Employee> findAllByNameContaining(String name, Pageable pageable);

}
