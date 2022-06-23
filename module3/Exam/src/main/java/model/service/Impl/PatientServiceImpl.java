package model.service.Impl;

import model.bean.Patient;
import model.bean.Records;
import model.repository.Impl.PatientRepositoryImpl;
import model.repository.PatientRepository;
import model.service.PatientService;
import utils.DateException;
import utils.Validate;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository=new PatientRepositoryImpl();
    private Validate validate = new Validate();
    @Override
    public List<Records> selectAllRecords() {
        return patientRepository.selectAllRecords();
    }

    @Override
    public List<Patient> selectAllPatients() {
        return  patientRepository.selectAllPatients();
    }

    @Override
    public Patient patient() {
        return null;
    }

    @Override
    public boolean insertPatient(Patient patient) throws SQLException {
        return patientRepository.insertPatient(patient);
    }

    @Override
    public Map<String, String> creatNewPatient(Patient patient) {
        Map<String, String> errorMap = new HashMap<>();
        if (Validate.regexIdStudent(patient.getPatient_id())){
            errorMap.put("idPatient", "ID Patient invalid ( BN-XXX. X is number ).");
        }

        try {
            if ( Validate.regexDate(patient.getDay_in() )){
                errorMap.put("date", "Date invalid.");
            }
        } catch (DateException e) {
            e.printStackTrace();
        }

        if (errorMap.isEmpty()){
            try {
                patientRepository.insertPatient(patient);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return errorMap;
    }

    @Override
    public boolean updatePatient(Patient patient) throws SQLException {
        return patientRepository.updatePatient(patient);
    }

    @Override
    public boolean deletePatient(String id) throws SQLException {
        return patientRepository.deletePatient(id);
    }

    @Override
    public void insertPatientList(List<Patient> list) {

    }

    @Override
    public boolean insertRecordsList(Records records) throws SQLException {
        return patientRepository.insertRecordsList(records);
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
        return patientRepository.getById(id);
    }

    @Override
    public List<Patient> searByName(String name) {
        return patientRepository.searByName(name);
    }

    @Override
    public List<Patient> sortListPatient(String name) {
        return null;
    }
}
