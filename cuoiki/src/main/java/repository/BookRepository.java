package repository;

import DAO.BookDAO;
import model.Book;
import model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements IBookRepository{
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<Book> selectAllBook() {
        Session currentSession = sessionFactory.getCurrentSession();
        //create a query
        Query<Book> theQuery=currentSession.createQuery("from Book ",Book.class);//lay lisst
        // execute query and get result list
        List<Book> bookList = theQuery.getResultList();
        for (Book book: bookList) {
            System.out.println(book.getBookCategoryId().getCategoryName());
        }
        return bookList;
    }

    @Transactional
    @Override
    public List<Book> getBooks(String kw) {//tim kiem theo ten
        Session currentSession = this.sessionFactory.getCurrentSession();
        CriteriaBuilder builder = currentSession.getCriteriaBuilder();
        CriteriaQuery<Book> query = builder.createQuery(Book.class);
        Root root = query.from(Book.class);
        query = query.select(root);

        if (!kw.isEmpty() && kw != null){
            Predicate p = builder.like(root.get("bookName").as(String.class),
                    String.format("%%%s%%",kw));//tuong doi

            query = query.where(p);
        }

        Query q = currentSession.createQuery(query);
        return q.getResultList();

    }

    @Override
    public Category getByIdCategory(Long id) {
        return null;
    }

    @Transactional
    @Override
    public List<Category> selectAllCategory() {
        Session currentSession = sessionFactory.getCurrentSession();
        //create a query
        Query<Category> theQuery=currentSession.createQuery("from Category ",Category.class);
        // execute query and get result list
        List<Category> categoryList = theQuery.getResultList();
        for (Category category: categoryList) {
            System.out.println(category.getCategoryName());
        }
        return categoryList;
    }

    @Transactional
    @Override
    public void saveBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        book.setBookCategoryId(session.get(Category.class,book.getBookCategoryId().getCategoryId()));
        session.save(book);
//        Transaction transaction = null;
//        try(Session session = sessionFactory.getCurrentSession()) {
//            transaction = session.beginTransaction();
//            book.setBookCategoryId(session.get(Category.class,book.getBookCategoryId().getCategoryId()));
//            session.save(book);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
    }

    @Transactional
    @Override
    public void updateBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);//update

//        Query query = session.createQuery("from Book WHERE book_id = :bookId");
//        query.setLong("bookId", book.getBookId());
//        Book book1 = (Book) query.uniqueResult();
//        try {
//            if (book1 ==null) {
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    @Transactional
    @Override
    public void deleteBook(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.get(Book.class, id);
        if (book != null) {
            session.delete(book);
            System.out.println("Đã xóa");
        }
    }

    @Transactional
    @Override
    public Book findBookById(Long bookId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Book WHERE book_id = :bookId");
        query.setLong("bookId", bookId);
        Book book = (Book) query.uniqueResult();
        return book;
    }


}
