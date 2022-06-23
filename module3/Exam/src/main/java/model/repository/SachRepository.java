package model.repository;

import model.bean.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface SachRepository {
    public List<Sach> selectAllBooks();
    public List<HocSinh> selectAllStudents();
    public List<TheMuonSach> selectAllTagBorrowBook();
    Sach sach();

    boolean insertBook(Sach sach) throws SQLException;
    boolean insertStudent(HocSinh hocSinh) throws SQLException;
    boolean muonSach(TheMuonSach theMuonSach) throws SQLException;

    boolean updateBook(Sach sach) throws SQLException;

    public Sach getById(String id);

    public List<Sach> searByNameBook(String name);
    public List<HocSinh> searByNameStudent(String name);

    public List<Sach> sortListBook(String name);
    boolean deleteBook(String id) throws SQLException;
}
