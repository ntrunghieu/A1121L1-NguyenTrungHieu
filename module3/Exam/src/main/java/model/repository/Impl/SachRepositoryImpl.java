package model.repository.Impl;

import model.bean.HocSinh;
import model.bean.Patient;
import model.bean.Sach;
import model.bean.TheMuonSach;
import model.repository.SachRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SachRepositoryImpl implements SachRepository {
    private static final String SELECT_ALL_BOOK =" select * from sach ; ";
    private static final String SELECT_ALL_STUDENT =" select * from hoc_sinh ; ";
    private static final String DELETE_QUANTITY_BOOK = " update sach\n" +
            "  set so_luong = so_luong - 1\n " +
            " where sach.ma_sach = 'S-001' ; ";
    private static final String SELECT_BOOK_BY_ID = " select * from sach where ma_sach = ?";
//    private final static String UPDATE_THE_MUON_SACH = "UPDATE patient SET `name` = ?,day_in = ?, " +
//            "date_out =?,reason=?" +
//            " WHERE " +
//            "patient_id=? ";
    private final static String INSERT_THE_MUON_SACH = " INSERT INTO the_muon_sach VALUE(?,?,?,?,?,?) ";

    public BaseRepository baseRepository=new BaseRepository();
    @Override
    public List<Sach> selectAllBooks() {
        List<Sach> sachList=new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOK);) {
//            statement.execute(DELETE_TRUNCATE_TABLE);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                String id = rs.getString("ma_sach");
                String tenSach = rs.getString("ten_sach");
                String tacGia = rs.getString("ten_sach");
                String moTa = rs.getString("mo_to");
                int soLuong = rs.getInt("so_luong");

                sachList.add(new Sach(id,tenSach,tacGia,moTa,soLuong));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sachList;
    }

    @Override
    public List<HocSinh> selectAllStudents() {
        List<HocSinh> hocSinhList=new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT);) {
//            statement.execute(DELETE_TRUNCATE_TABLE);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                String id = rs.getString("ma_hs");
                String hoTen = rs.getString("ho_ten");
                String lop = rs.getString("lop");

                hocSinhList.add(new HocSinh(id,hoTen,lop));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hocSinhList;
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
    public boolean muonSach(TheMuonSach theMuonSach) throws SQLException {
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_THE_MUON_SACH);

        java.sql.Date sqlBod_in = new java.sql.Date(theMuonSach.getNgayMuon().getTime());
        java.sql.Date sqlBod_out = new java.sql.Date(theMuonSach.getNgayTra().getTime());

//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
////        String bod = null;
//        java.sql.Date bod1 = (java.sql.Date) new Date();
//        try {
//            bod1 = (java.sql.Date) formatter.parse(patient.getDay_in());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        preparedStatement.setString(1,theMuonSach.getMaMuon());
        preparedStatement.setString(2,theMuonSach.getMaSach());
        preparedStatement.setString(3,theMuonSach.getMaHocSinh());
        preparedStatement.setInt(4,theMuonSach.isTrangThai());
        preparedStatement.setDate(5, sqlBod_in);
        preparedStatement.setDate(6, sqlBod_out);


        boolean check = preparedStatement.executeUpdate()>0;
        connection.close();

        return check;
    }

    @Override
    public boolean updateBook(Sach sach) throws SQLException {
//        Connection connection = baseRepository.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_THE_MUON_SACH);


//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date bod = null;
//        Date bod1 = new Date();
//        try {
//            bod1 = formatter.parse(patient.getDay_in());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


//        java.sql.Date sqlBod_in = new java.sql.Date(patient.getDay_in().getTime());
//
//        java.sql.Date sqlBod_out = new java.sql.Date(patient.getDay_out().getTime());
//
//        preparedStatement.setString(1,patient.getName());
//        preparedStatement.setDate(2, sqlBod_in);
//        preparedStatement.setDate(3, sqlBod_out);
//        preparedStatement.setString(4,patient.getReason());
//        preparedStatement.setString(5,patient.getPatient_id());
//
//        boolean check = preparedStatement.executeUpdate() > 0;
//        connection.close();
//
//        return check;
        return true;
        }

    @Override
    public Sach getById(String id) {
        try (Connection connection = baseRepository.getConnection(); PreparedStatement
                ps = connection.prepareCall(SELECT_BOOK_BY_ID)) {

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String idBook = rs.getString("ma_sach");
                String tenSach = rs.getString("ten_sach");
                String tacGia = rs.getString("ten_sach");
                String moTa = rs.getString("mo_to");
                int soLuong = rs.getInt("so_luong");

                return new Sach(idBook,tenSach,tacGia,moTa,soLuong);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;    }

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


//    @Override
//    public List<Sach> searByName(String name) {
//        List<Sach>   = new ArrayList<>();
//        //cach 1
//        try (Connection connection = baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME)) {
//            preparedStatement.setString(1, "%" + name + "%");
//            System.out.println(SEARCH_BY_NAME);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                String id = rs.getString("patient_id");
//                String namePatient = rs.getString("name");
////                Date dateIn = rs.getString("day_in");
//                java.sql.Date dateIn = rs.getDate("day_in");
//                java.util.Date dateOut = rs.getDate("date_out");
//                String reason = rs.getString("reason");
//                patientList.add(new Patient(id,namePatient,dateIn,dateOut,reason));
//            }
//            connection.close();
//        } catch (SQLException x) {
//            x.printStackTrace();
//        }
//        return patientList;
//    }


    @Override
    public boolean deleteBook(String id) throws SQLException {
        return false;
    }
}
