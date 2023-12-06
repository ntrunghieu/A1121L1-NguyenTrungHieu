package springdemo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import springdemo.model.bean.Fruit;

@Repository
public class FruitDAO implements IFruitDAO {
    
    
   public FruitDAO() {
	// TODO Auto-generated constructor stub
   }
    

	@Override
	public void insertFruit(Fruit fruit) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Fruit selectFruit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fruit> selectAllFruits() {
	
		
		return null;
	}

	@Override
	public boolean deleteFruit(int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(Fruit fruit) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
