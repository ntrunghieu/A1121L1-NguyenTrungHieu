package DAO;

import model.Book;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BookDAO implements IBookDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/cuoiki?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Ntrunghieu27";
    private static final String SELECT_ALL_BOOKS = "select * from book";
//    @Override
//    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Book book = new Book();
//        book.setBookId(rs.getLong("book_id"));
//        book.setBookCode(rs.getString("book_code"));
//        book.setBookName(rs.getString("book_name"));
//        book.setBookImage(rs.getString("book_image"));
//        book.setBookContent(rs.getString("book_content"));
//        book.setBookId(rs.getLong("book_id"));
//        book.setBookId(rs.getLong("book_id"));
//        book.setBookId(rs.getLong("book_id"));
//        book.setBookStatus(rs.getBoolean("book_status"));
//        book.setBookPrice(rs.getDouble("book_price"));
//        book.setBookTranslator(rs.getString("book_translator"));
//        book.setBookQuantity(rs.getInt("book_quantity"));
//        book.setBookFlag(rs.getBoolean("book_flag"));
//        book.setBookPublisher(rs.getString("book_publisher"));
//        book.setBookAuthor(rs.getString("book_author"));
//
//        return book;
//    }
    public BookDAO(){}
    protected Connection getConnect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public List<Book> selectAllBook() {
        List<Book> bookList = new ArrayList<>();
        BookDAO bookDAO = new BookDAO();
        try (Connection connection = getConnect();
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);) {
//            statement.execute(DELETE_TRUNCATE_TABLE);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("book_id");
                String name = rs.getString("book_name");
                String code = rs.getString("book_code");
                String img = rs.getString("book_image");
                String content = rs.getString("book_content");
                Boolean status = rs.getBoolean("book_status");
                Double price = rs.getDouble("book_price");
                String translator = rs.getString("book_translator");
                Integer quantity = rs.getInt("book_quantity");
                Boolean flag = rs.getBoolean("book_flag");
                String publisher = rs.getString("book_publisher");
                String author = rs.getString("book_author");
                Long cateId = rs.getLong("book_category_id");
                bookList.add(new Book(id,code,name,img,content,status,price,translator,quantity,flag,publisher,author,bookDAO.getByIdCategory(cateId)));
                for (Book book: bookList) {
                    System.out.println(book.getBookName());
                }
//        book.setBookCode(rs.getString("book_code"));
//        book.setBookName(rs.getString("book_name"));
//        book.setBookImage(rs.getString("book_image"));
//        book.setBookContent(rs.getString("book_content"));
//        book.setBookId(rs.getLong("book_id"));
//        book.setBookId(rs.getLong("book_id"));
//        book.setBookId(rs.getLong("book_id"));
//        book.setBookStatus(rs.getBoolean("book_status"));
//        book.setBookPrice(rs.getDouble("book_price"));
//        book.setBookTranslator(rs.getString("book_translator"));
//        book.setBookQuantity(rs.getInt("book_quantity"));
//        book.setBookFlag(rs.getBoolean("book_flag"));
//        book.setBookPublisher(rs.getString("book_publisher"));
//        book.setBookAuthor(rs.getString("book_author"));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookList;
    }

    @Override
    public Category getByIdCategory(Long id) {
        Category category = null;
        String query = "{call get_cate_by_id(?)}";
        try (Connection connection = getConnect(); CallableStatement
                callableStatement = connection.prepareCall(query)) {

            callableStatement.setLong(1, id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                Long idCate = rs.getLong("category_id");
                String name = rs.getString("category_name");


                category = new Category(idCate, name);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return category;
    }
}
