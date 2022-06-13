package model.service;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import model.bean.employee.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeService {
    public List<Employee> selectAllTypeEmployee();

    public void insertEmployee(Employee employee) throws SQLException;
    public Employee setIdEmployee(int typeId, String name, String birthday, int gender, String idCard, String phone, String email, String address);
    public Employee selectEmployee(int id);

    public List<Employee> selectAllEmployee();

    public boolean deleteEmployee(int id) throws SQLException;

    public boolean updateEmployee(Employee employee) throws SQLException;
    public Employee accountEmployee(String name, String email, String country);
    public Employee getById(int id);
    public List<Employee> searByCountry(String name);
    public List<Employee> sortListEmployee(String name);
}
