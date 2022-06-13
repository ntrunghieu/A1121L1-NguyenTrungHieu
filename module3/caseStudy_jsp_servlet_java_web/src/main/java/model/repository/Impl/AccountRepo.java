package model.repository.Impl;

import model.bean.Account;
import model.repository.IAccountRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepo implements IAccountRepo {
    private BaseRepo baseRepo = new BaseRepo();
    private static final String SELECT_ACCOUNT = "select * from  user  where `username` = ? and  `password` = ? ;";
    private static List<Account> userList = new ArrayList<>();

    static {
        userList.add(new Account(1, "hieutrung", "123", "ADMIN"));
        userList.add(new Account(2, "guest1", "123", "USER"));
        userList.add(new Account(3, "guest2", "123", "USER"));
    }
    @Override
    public Account login(String user, String pass) {


        try (Connection connection = baseRepo.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ACCOUNT);) {
            ps.setString(1, user);
            ps.setString(2, pass);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1), rs.getString(2));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
