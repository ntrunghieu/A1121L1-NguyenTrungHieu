package service;

import model.Book;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IBookRepository;

import java.util.List;
@Service
public class BookService implements IBookService{
    @Autowired private IBookRepository bookRepository;

    @Override
    public List<Book> selectAllBook() {
        return bookRepository.selectAllBook();
    }

    @Override
    public List<Book> getBooks(String kw) {
        return bookRepository.getBooks(kw);
    }

    @Override
    public Category getByIdCategory(Long id) {
        return null;
    }

    @Override
    public List<Category> selectAllCategory() {
        return bookRepository.selectAllCategory();
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.saveBook(book);
    }

    @Override
    public Book findBookById(Long bookId) {
        return bookRepository.findBookById(bookId);
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.updateBook(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteBook(id);
    }
}
