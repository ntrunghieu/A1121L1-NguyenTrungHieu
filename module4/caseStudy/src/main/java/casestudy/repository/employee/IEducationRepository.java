package casestudy.repository.employee;

import casestudy.entity.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationRepository extends JpaRepository<EducationDegree, Long> {
}
