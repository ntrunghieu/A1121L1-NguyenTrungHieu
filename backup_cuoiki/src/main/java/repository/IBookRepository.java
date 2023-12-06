package repository;

import model.Book;
import model.Category;

import java.util.List;

public interface IBookRepository {
    public List<Book> selectAllBook();
    public List<Book> getBooks(String kw);
    public Category getByIdCategory(Long id);
    public List<Category> selectAllCategory();
    void saveBook(Book book);
    void updateBook(Book book);
    void deleteBook(Long id);
    public Book findBookById(Long bookId);

}
