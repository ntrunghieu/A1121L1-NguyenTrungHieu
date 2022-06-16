package model.service.Impl;

import model.bean.HocSinh;
import model.bean.Patient;
import model.bean.Sach;
import model.bean.TheMuonSach;
import model.repository.Impl.SachRepositoryImpl;
import model.repository.SachRepository;
import model.service.SachService;

import java.sql.SQLException;
import java.util.List;

public class SachServiceImpl implements SachService {
    private SachRepository sachRepository=new SachRepositoryImpl();
    @Override
    public List<Sach> selectAllBooks() {
        return sachRepository.selectAllBooks();
    }

    @Override
    public List<HocSinh> selectAllStudents() {
        return sachRepository.selectAllStudents();
    }

    @Override
    public Sach sach() {
        return null;
    }

    @Override
    public boolean insertBook(Sach sach) throws SQLException {
        return false;
    }

    @Override
    public boolean insertStudent(HocSinh hocSinh) throws SQLException {
        return false;
    }

    @Override
    public boolean updateBook(Sach sach) throws SQLException {
        return false;
    }

    @Override
    public boolean muonSach(TheMuonSach theMuonSach) throws SQLException {
        return sachRepository.muonSach(theMuonSach);
    }

    @Override
    public boolean deleteBook(String id) throws SQLException {
        return false;
    }

    @Override
    public Patient getById(String id) {
        return null;
    }

    @Override
    public List<Sach> searByNameBook(String name) {
        return null;
    }

    @Override
    public List<HocSinh> searByNameStudent(String name) {
        return null;
    }

    @Override
    public List<Sach> sortListBook(String name) {
        return null;
    }


}
