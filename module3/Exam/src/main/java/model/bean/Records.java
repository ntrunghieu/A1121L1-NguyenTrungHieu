package model.bean;
public class Records {
    private String patient_id;
    private String records_id;

    public Records() {
    }

    public Records(String patient_id, String records_id) {
        this.patient_id = patient_id;
        this.records_id = records_id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getRecords_id() {
        return records_id;
    }

    public void setRecords_id(String records_id) {
        this.records_id = records_id;
    }
}
