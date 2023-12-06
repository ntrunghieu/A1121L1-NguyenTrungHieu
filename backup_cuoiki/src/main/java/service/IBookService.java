package service;

import model.Book;
import model.Category;

import java.util.List;

public interface IBookService {
    public List<Book> selectAllBook();
    public List<Book> getBooks(String kw);
    public Category getByIdCategory(Long id);

    List<Category> selectAllCategory();
    void saveBook(Book book);

    public Book findBookById(Long bookId);

    public void updateBook(Book book);
    void deleteBook(Long id);
}
