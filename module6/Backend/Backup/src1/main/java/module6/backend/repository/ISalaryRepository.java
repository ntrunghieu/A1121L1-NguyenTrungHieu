package module6.backend.repository;

import module6.backend.entity.employee.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalaryRepository extends JpaRepository<Salary, Long> {
}
