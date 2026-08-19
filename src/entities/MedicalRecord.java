package entities;

import java.awt.*;
import java.util.Date;

public class MedicalRecord {


    private Long recordId;
    private Long patientId;
    private Long doctorId;
    private Date visitDate;
    private String diagnosis;
    private String prescription;
    private TextArea notes;
    private Boolean isConfidential;

    public MedicalRecord(TextArea notes, String diagnosis, Long doctorId, Boolean isConfidential, Long patientId, String prescription, Long recordId, Date visitDate) {
        this.notes = notes;
        this.diagnosis = diagnosis;
        this.doctorId = doctorId;
        this.isConfidential = isConfidential;
        this.patientId = patientId;
        this.prescription = prescription;
        this.recordId = recordId;
        this.visitDate = visitDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public TextArea getNotes() {
        return notes;
    }

    public void setNotes(TextArea notes) {
        this.notes = notes;
    }

    public Boolean getConfidential() {
        return isConfidential;
    }

    public void setConfidential(Boolean confidential) {
        isConfidential = confidential;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }
}
