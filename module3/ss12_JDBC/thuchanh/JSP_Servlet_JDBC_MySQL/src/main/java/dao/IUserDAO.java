package dao;

import model.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;
    public User accountUser(String name, String email, String country);
    public User getById(int id);
    public List<User> searByCountry(String name);
    public List<User> sortListUser(String name);
    public void addUserTransaction(User user, int[] permission);
    public User setIdUser(String name, String email, String address);
    public void insertUpdateWithoutTransaction();
    public void insertUpdateUseTransaction();
}
