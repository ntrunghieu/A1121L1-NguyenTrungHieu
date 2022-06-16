package model.service;

import model.bean.HocSinh;
import model.bean.Patient;
import model.bean.Sach;
import model.bean.TheMuonSach;

import java.sql.SQLException;
import java.util.List;

public interface SachService {

    public List<Sach> selectAllBooks();
    public List<HocSinh> selectAllStudents();

    Sach sach();

    boolean insertBook(Sach sach) throws SQLException;
    boolean insertStudent(HocSinh hocSinh) throws SQLException;

    boolean updateBook(Sach sach) throws SQLException;
    boolean muonSach(TheMuonSach theMuonSach) throws SQLException;
    boolean deleteBook(String id) throws SQLException;
    public Patient getById(String id);

    public List<Sach> searByNameBook(String name);
    public List<HocSinh> searByNameStudent(String name);

    public List<Sach> sortListBook(String name);
}
