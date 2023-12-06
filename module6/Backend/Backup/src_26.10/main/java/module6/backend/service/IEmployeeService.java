package module6.backend.service;

import module6.backend.entity.employee.Employee;
import module6.backend.entity.employee.Position;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Optional<Employee> findEmployeeById(Long id);

    void updateEmployee(String employeeName, String employeeAvatar, LocalDate employeeDateOfBirth, String employeeGender, String employeeAddress, String employeePhone, Long employeeId);

    //NhiVP code tim employee bang code
    Employee findEmployeeByCode(String code);

    //NhiVP code tim employee da co account
    List<String> findAllEmployeeHasAccount();

    //NhiVP code lấy danh sách mã nhân viên chưa có tài khoản
    List<String> findAllEmployeeDontHasAccount();

    Optional<Employee> findById(Long id);

    List<Employee> getAllEmployeeWithPagination(int index);


    void deleteEmployeeById(Long id1, Long id2);

    List<Employee> getAllEmployee();

    void adminUpdateEmployee(String employeeName, String employeeCode, String employeeAvatar, LocalDate employeeDateOfBirth, String employeeGender, String employeeAddress, String employeePhone, Double employeeSalary, Long employeePositionId, Long employeeId);

    void saveEmployee(String employeeCode, String employeeName, String employeeAvatar, LocalDate employeeDateOfBirth, String employeeGender, String employeeAddress, String employeePhone, Double employeeSalary, Long employeePositionId);

    List<Position> getAllPosition();

}
