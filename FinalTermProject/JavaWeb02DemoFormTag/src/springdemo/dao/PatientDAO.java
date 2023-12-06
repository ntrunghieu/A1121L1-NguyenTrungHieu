package springdemo.dao;

import java.util.List;

import org.hibernate.*;

import springdemo.model.bean.Patient;


public class PatientDAO {

    public void insertPatient(Patient patient) {
    	Session session = null;
		session = HibernateDatabaseConnection.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		session.save(patient);
		t.commit();

    }

    public Patient getPatient(int patientId) {
    	Session session = null;
		session = HibernateDatabaseConnection.getSessionFactory().openSession();
        Patient patient = null;

        try {
            patient = session.get(Patient.class, patientId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return patient;
    }

    public List<Patient> getAllPatients() {
    	Session session = null;
		session = HibernateDatabaseConnection.getSessionFactory().openSession();
		List<Patient> patients = session.createQuery("FROM Patient ORDER BY id ASC", Patient.class)
                .getResultList();
        return patients;
    }

}

