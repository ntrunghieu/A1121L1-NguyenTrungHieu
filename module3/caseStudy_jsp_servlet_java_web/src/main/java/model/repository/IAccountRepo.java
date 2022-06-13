package model.repository;

import model.bean.Account;

public interface IAccountRepo {
    Account login(String user, String pass);
}
