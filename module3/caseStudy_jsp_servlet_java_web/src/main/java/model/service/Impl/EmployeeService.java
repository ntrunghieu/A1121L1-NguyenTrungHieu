package model.service.Impl;

import model.bean.customer.Customer;
import model.bean.employee.Employee;
import model.repository.IEmployeeRepo;
import model.service.IEmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService implements IEmployeeService {
    @Override
    public List<Employee> selectAllTypeEmployee() {
        return null;
    }

    @Override
    public void insertEmployee(Employee employee) throws SQLException {

    }


    @Override
    public Employee setIdEmployee(int typeId, String name, String birthday, int gender, String idCard, String phone, String email, String address) {
        return null;
    }

    @Override
    public Employee selectEmployee(int id) {
        return null;
    }

    @Override
    public List<Employee> selectAllEmployee() {
        return null;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        return false;
    }


    @Override
    public Employee accountEmployee(String name, String email, String country) {
        return null;
    }

    @Override
    public Employee getById(int id) {
        return null;
    }

    @Override
    public List<Employee> searByCountry(String name) {
        return null;
    }

    @Override
    public List<Employee> sortListEmployee(String name) {
        return null;
    }
}
