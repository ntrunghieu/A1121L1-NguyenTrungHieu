package springdemo.dao;

import java.sql.SQLException;
import java.util.List;

import springdemo.model.bean.Fruit;

public interface IFruitDAO {
	 public void insertFruit(Fruit fruit) throws SQLException;

	 public Fruit selectFruit(int id);

	 public List<Fruit> selectAllFruits();

	 public boolean deleteFruit(int id) throws SQLException;

	 public boolean updateUser(Fruit fruit) throws SQLException;	
}
