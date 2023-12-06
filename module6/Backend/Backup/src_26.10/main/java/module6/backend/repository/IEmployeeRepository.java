package module6.backend.repository;

import module6.backend.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "select * from employee where employee_id = ?1 and employee_position_id > 0 and employee_account_id > 0 and employee_flag = 0 ", nativeQuery = true)
    Optional<Employee> findEmployeeById(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE employee SET employee_name = ?1, employee_avatar = ?2, employee_date_of_birth= ?3, employee_gender = ?4, employee_address = ?5, employee_phone = ?6 WHERE employee_id = ?7", nativeQuery = true)
    void updateEmployee(String employeeName, String employeeAvatar, LocalDate employeeDateOfBirth, String employeeGender, String employeeAddress, String employeePhone, Long employeeId);

    //NhiVP code tim employee bang code
    @Query(value = "SELECT * from employee where employee_code =?1 and employee_flag = 0", nativeQuery = true)
    Employee findEmployeeByCode(String code);

    //NhiVP code tim employee da co account
    @Query(value = "select * from employee where employee_code =?1 and employee_account_id is not null and employee_flag = 0", nativeQuery = true)
    Employee findExistEmployeeHasAccount(String code);

    //NhiVP code tim employee chua co account
    @Query(value = "select * from employee where employee_code =?1 and employee_account_id is null and employee_flag = 0", nativeQuery = true)
    Employee findExistEmployeeDontHasAccount(String code);

    //NhiVP code lấy danh sách mã nhân viên đã có tài khoản
    @Query(value = "select employee_code from employee where employee_code is not null and employee_account_id is not null and employee_flag = 0", nativeQuery = true)
    List<String> findAllEmployeeHasAccount();

    @Query(value = "select employee_code from employee where employee_code is not null and employee_account_id is null and employee_flag = 0", nativeQuery = true)
    List<String> findAllEmployeeDontHasAccount();


    // Thắng code lấy list admin người thực hiện
    @Query(value = "SELECT * FROM employee where (employee_position_id = 1 or employee_position_id = 3) and employee_account_id > 0 and employee_position_id > 0 and employee_id > 0;", nativeQuery = true)
    List<Employee> findAllEmployeeImport();

    @Query(value = "SELECT * from employee left join position on position.position_id = employee.employee_position_id where employee.employee_flag = 0 group by employee.employee_id limit ?1,5", nativeQuery = true)
    List<Employee> getAllEmployeeWithPagination(int index);

    @Query(value = "UPDATE employee SET employee_flag = 1 , employee_id = ?1  WHERE (employee_id = ?2)", nativeQuery = true)
    @Transactional
    @Modifying
    void deleteEmployeeById(Long id1, Long id2);

    @Query(value = "select * from employee where employee_position_id  > 0 and employee_flag = 0", nativeQuery = true)
    List<Employee> getAllEmployee();

    @Modifying
    @Transactional
    @Query(value = "insert into `employee` (`employee_code`,+ `employee_name`, + `employee_avatar`,+ `employee_date_of_birth`,+`employee_gender`,+` employee_address`,+ `employee_phone`,+`employee_salary`,+` employee_position_id)` +values(?1,?2,?3,?4,?5,?6,?7,?8,?9)", nativeQuery = true)
    void saveEmployee(String employeeCode, String employeeName, String employeeAvatar, LocalDate employeeDateOfBirth, String employeeGender, String employeeAddress, String employeePhone, Double employeeSalary, Long employeePositionId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE `employee` SET `employee_name` = ?1,`employee_code` = ?2 , `employee_avatar` = ?3, `employee_date_of_birth`= ?4, `employee_gender` = ?5, `employee_address` = ?6, `employee_phone` = ?7 , `employee_salary` = ?8  , `employee_position` = ?9 WHERE `employee_id` = ?10", nativeQuery = true)
    void adminUpdateEmployee(String employeeName, String employeeCode, String employeeAvatar, LocalDate employeeDateOfBirth, String employeeGender, String employeeAddress, String employeePhone, Double employeeSalary, Long employeePositionId, Long employeeId);
}
