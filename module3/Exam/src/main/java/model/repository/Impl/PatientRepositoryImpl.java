package model.repository.Impl;

import model.bean.Patient;
import model.bean.Records;
import model.repository.PatientRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientRepositoryImpl implements PatientRepository {
    private static final String SELECT_ALL_PATIENT =" select * from patient; ";
    private final static String UPDATE_PATIENT = "UPDATE patient SET `name` = ?,day_in = ?, " +
            "date_out =?,reason=?" +
            " WHERE " +
            "patient_id=? ";
    private static final String SELECT_PATIENT_BY_ID = "select * from patient where patient_id = ?";
    private static final String DELETE_PATIENT_SQL = " delete from patient where patient_id = ? ;";
    private final static String INSERT_PATIENT = "INSERT INTO patient VALUES(?,?,?,?,?)";
    private final static String INSERT_RECORDS = "INSERT INTO records VALUES(?,?)";
    private static final String SEARCH_BY_NAME = " select * from patient where `name` like ? ;";

    public BaseRepository baseRepository=new BaseRepository();
    @Override
    public List<Records> selectAllRecords() {
     return null;
    }

    @Override
    public List<Patient> selectAllPatients() {
        List<Patient> patientList=new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PATIENT);) {
//            statement.execute(DELETE_TRUNCATE_TABLE);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                String id = rs.getString("patient_id");
                String name = rs.getString("name");
                java.util.Date dateIn = rs.getDate("day_in");
                java.util.Date dateOut = rs.getDate("date_out");
                String reason = rs.getString("reason");
                patientList.add(new Patient(id,name,dateIn,dateOut,reason));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return patientList;
    }

    @Override
    public Patient patient() {
        Patient patient=new Patient();
        String id = patient.getPatient_id();
        String name = patient.getName();
        Date dateIn = patient.getDay_in();
        java.util.Date dateOut = patient.getDay_out();
        String reason = patient.getReason();
        return new Patient(id,name,dateIn,dateOut,reason);
    }

    @Override
    public boolean insertPatient(Patient patient) throws SQLException {
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PATIENT);
        java.sql.Date sqlBod_in = new java.sql.Date(patient.getDay_in().getTime());
        java.sql.Date sqlBod_out = new java.sql.Date(patient.getDay_out().getTime());

//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
////        String bod = null;
//        java.sql.Date bod1 = (java.sql.Date) new Date();
//        try {
//            bod1 = (java.sql.Date) formatter.parse(patient.getDay_in());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        preparedStatement.setString(1,patient.getPatient_id());
        preparedStatement.setString(2,patient.getName());
        preparedStatement.setDate(3, sqlBod_in);
        preparedStatement.setDate(4, sqlBod_out);
        preparedStatement.setString(5,patient.getReason());


        boolean check = preparedStatement.executeUpdate()>0;
        connection.close();

        return check;
    }

    @Override
    public boolean insertRecordsList(Records records) throws SQLException {
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RECORDS);


        preparedStatement.setString(1,records.getRecords_id());
        preparedStatement.setString(2,records.getPatient_id());

        boolean check = preparedStatement.executeUpdate()>0;
        connection.close();

        return check;
    }

    @Override
    public boolean updatePatient(Patient patient) throws SQLException {
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PATIENT);
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date bod = null;
//        Date bod1 = new Date();
//        try {
//            bod1 = formatter.parse(patient.getDay_in());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        java.sql.Date sqlBod_in = new java.sql.Date(patient.getDay_in().getTime());

        java.sql.Date sqlBod_out = new java.sql.Date(patient.getDay_out().getTime());

        preparedStatement.setString(1,patient.getName());
        preparedStatement.setDate(2, sqlBod_in);
        preparedStatement.setDate(3, sqlBod_out);
        preparedStatement.setString(4,patient.getReason());
        preparedStatement.setString(5,patient.getPatient_id());

        boolean check = preparedStatement.executeUpdate() > 0;
        connection.close();

        return check;
    }

    @Override
    public boolean deletePatient(String id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = baseRepository.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PATIENT_SQL);) {
            statement.setString(1, id);
            rowDeleted = statement.executeUpdate() > 0;


        }
        return rowDeleted;
    }

    @Override
    public void insertPatientList(List<Patient> list) {

    }

    @Override
    public Patient setIdUser(int typeId, String name, String birthday, int gender, String idCard, String phone, String email, String address) {
        return null;
    }

    @Override
    public Patient selectCustomer(int id) {
        return null;
    }

    @Override
    public Patient accountPatient(String name, String email, String country) {
        return null;
    }

    @Override
    public Patient getById(String id) {
        try (Connection connection = baseRepository.getConnection(); PreparedStatement
                ps = connection.prepareCall(SELECT_PATIENT_BY_ID)) {

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String idPatient = rs.getString("patient_id");
                String name = rs.getString("name");
//                Date dateIn = rs.getString("day_in");
                java.sql.Date dateIn = rs.getDate("day_in");
                java.sql.Date dateOut = rs.getDate("date_out");
                String reason = rs.getString("reason");
                return new Patient(idPatient,name,dateIn,dateOut,reason);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Patient> searByName(String name) {
        List<Patient> patientList = new ArrayList<>();
        //cach 1
        try (Connection connection = baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME)) {
            preparedStatement.setString(1, "%" + name + "%");
            System.out.println(SEARCH_BY_NAME);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("patient_id");
                String namePatient = rs.getString("name");
//                Date dateIn = rs.getString("day_in");
                java.sql.Date dateIn = rs.getDate("day_in");
                java.util.Date dateOut = rs.getDate("date_out");
                String reason = rs.getString("reason");
                patientList.add(new Patient(id,namePatient,dateIn,dateOut,reason));
            }
            connection.close();
        } catch (SQLException x) {
            x.printStackTrace();
        }
        return patientList;
    }

    @Override
    public List<Patient> sortListPatient(String name) {
        return null;
    }
}
