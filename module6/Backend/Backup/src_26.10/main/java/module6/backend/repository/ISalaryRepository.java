package module6.backend.repository;

import module6.backend.entity.employee.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ISalaryRepository extends JpaRepository<Salary, Long> {

    @Query(value = "select sum(salary_advance_payment) as luong_nhan_vien from salary; ", nativeQuery = true)
    Integer luong();
}
