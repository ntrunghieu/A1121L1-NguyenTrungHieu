package repository;

import model.Customer;
import model.CustomerType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository{
    public final String SELECT_ALL = " select * from customer " ;
    public final String INSERT = " INSERT INTO customer( `name` , address, id_customer_type) " +
            " values( ?, ?, ?  ) " ;
    public final String SELECT_ALL_CUSTOMER_TYPE = " select * from customer_type " ;
    private  BaseRepository baseRepository = new BaseRepository();

    public List<CustomerType> getAllCustomerType() {
        List<CustomerType> customerList = new ArrayList<>();
        try(Connection connection = baseRepository.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                CustomerType customerType = new CustomerType( id, name );
                customerList.add(customerType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }


    @Override
    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();
        try(Connection connection = baseRepository.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                int idCustomerType = resultSet.getInt("id_customer_type");
                Customer customer = new Customer( id, name, address, idCustomerType );
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void createNewCustomer(Customer customer) {
        try(Connection connection = baseRepository.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setInt(3, customer.getIdCustomerType());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(Customer customer) {

    }
}
