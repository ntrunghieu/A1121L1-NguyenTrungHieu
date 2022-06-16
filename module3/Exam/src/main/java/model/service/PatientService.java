package model.service;

import model.bean.Patient;
import model.bean.Records;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface PatientService {
    public List<Records> selectAllRecords();
    public List<Patient> selectAllPatients();

    //    public void insertCustomer(Customer customer) throws SQLException;
//    public boolean deleteCustomer(int id) throws SQLException;
//    public boolean updateCustomer(Customer customer) throws SQLException;
    Patient patient();

    boolean insertPatient(Patient patient) throws SQLException;
    Map<String, String> creatNewPatient(Patient patient);
    boolean updatePatient(Patient patient) throws SQLException;

    boolean deletePatient(String id) throws SQLException;

    void insertPatientList(List<Patient> list);
    boolean insertRecordsList(Records records) throws SQLException;

    public Patient setIdUser(int typeId, String name, String birthday, int gender, String idCard, String phone, String email, String address);
    public Patient selectCustomer(int id);




    public Patient accountPatient(String name, String email, String country);

    public Patient getById(String id);

    public List<Patient> searByName(String name);

    public List<Patient> sortListPatient(String name);
}
