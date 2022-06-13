package model.repository.Impl;

import model.bean.employee.Employee;
import model.repository.IEmployeeRepo;

import java.sql.SQLException;
import java.util.List;

public class EmployeeRepo implements IEmployeeRepo{
    private BaseRepo baseRepo=new BaseRepo();


    private static final String SELECT_TYPE_CUS ="select * from customer_type;";
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO customer" + "  (customer_type_id,customer_name, customer_birhday, customer_gender," +
            "customer_id_card,customer_phone,customer_email,customer_address) VALUES " +
            " (?, ?, ?,?,?,?,?,?);";
    private static final String SET_ID = "select * from users where customer_type_id = ? and customer_name = ? and customer_birhday = ?" +
            " and customer_gender = ? and customer_id_card = ? and customer_phone = ? and customer_email = ? and customer_address = ?;";
    private static final String SELECT_CUSTOMER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_CUSTOMERS = "select * from customer";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String DELETE_TRUNCATE_TABLE = "truncate table users";
    private static final String SEARCH_BY_COUNTRY = "select * from users where country like ? ;";
    private static final String SORT_USERS_SQL_NAME = "select * from users order by name ASC;";
    private static final String SORT_USERS_SQL_EMAIL = "select * from users order by email ASC;";
    private static final String SORT_USERS_SQL_COUNTRY = "select * from users order by country ASC;";
    private static final String SQL_INSERT = "INSERT INTO employee (name, salary, created_date) VALUES (?,?,?)";

    private static final String SQL_UPDATE = "UPDATE employee SET salary=? WHERE name=?";

    private static final String SQL_TABLE_CREATE = "CREATE TABLE employee"

            + "("

            + " id serial,"

            + " name varchar(100) NOT NULL,"

            + " salary numeric(15, 2) NOT NULL,"

            + " created_date timestamp,"

            + " PRIMARY KEY (id)"

            + ")";

    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS employee";

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
