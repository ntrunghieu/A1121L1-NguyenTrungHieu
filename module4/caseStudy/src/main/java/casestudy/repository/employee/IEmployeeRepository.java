package casestudy.repository.employee;

import casestudy.entity.employee.Division;
import casestudy.entity.employee.EducationDegree;
import casestudy.entity.employee.Employee;
import casestudy.entity.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    Iterable<Employee> findAllByEducationDegree(EducationDegree education);
    Iterable<Employee> findAllByPosition(Position position);
    Iterable<Employee> findAllByDivision(Division division);

    


    Page<Employee> findAllByNameContaining(String name, Pageable pageable);

//    @Query(value = "select * from employee where id = ?1", nativeQuery = true)
//    Employee findById1(Long id);
}
