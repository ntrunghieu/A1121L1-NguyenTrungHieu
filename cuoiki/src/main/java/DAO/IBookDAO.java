package DAO;

import model.Book;
import model.Category;

import java.util.List;

public interface IBookDAO {
    public List<Book> selectAllBook();

    public Category getByIdCategory(Long id);
}
