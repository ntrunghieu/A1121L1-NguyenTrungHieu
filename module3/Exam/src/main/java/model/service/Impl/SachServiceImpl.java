package model.service.Impl;

import model.bean.HocSinh;
import model.bean.Patient;
import model.bean.Sach;
import model.bean.TheMuonSach;
import model.repository.Impl.SachRepositoryImpl;
import model.repository.SachRepository;
import model.service.SachService;
import utils.Validate;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<TheMuonSach> selectAllTagBorrowBook() {
        return sachRepository.selectAllTagBorrowBook();
    }


    @Override
    public Map<String, String> regexMaHS(HocSinh hocSinh) {
        Map<String, String> errorMap = new HashMap<>();
        if (Validate.regexIdStudent(hocSinh.getMaHS())){
            errorMap.put("maHS", "Mã không đúng (HS-XXX. X là số).");
        }
        return errorMap;
    }

    @Override
    public Map<String, String> regexMaMuonSach(TheMuonSach theMuonSach) {
        Map<String, String> errorMap = new HashMap<>();
        if (Validate.regexIdBook(theMuonSach.getMaMuon())){
            errorMap.put("maMuonSach", "Mã không đúng (MS-XXX. X là số).");
        }else {
            errorMap.put("maMuonSach", " ");
        }


//        if (errorMap.isEmpty()){
//            try {
//                sachRepository.muonSach(theMuonSach);
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
        return errorMap;
    }

    @Override
    public Map<String, String> regexMaSach(Sach sach) {
            Map<String, String> errorMap = new HashMap<>();
            if (Validate.regexIdBook(sach.getMaSach())){
                errorMap.put("maSach", "Mã không đúng (S-XXX. X là số).");
            }

            return errorMap;
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
        return sachRepository.insertStudent(hocSinh);
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
