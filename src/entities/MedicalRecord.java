package entities;

import interfaces.Displayable;

import java.awt.*;
import java.util.Date;
import java.util.List;

public class MedicalRecord implements Displayable {


    private Long recordId;
    private Long patientId;
    private Long doctorId;
    private Date visitDate;
    private String diagnosis;
    private String prescription;
    private List<String> notes;
    private Boolean isConfidential;


    public MedicalRecord(String diagnosis, Long doctorId, Boolean isConfidential, List<String> notes, Long patientId, String prescription, Long recordId, Date visitDate) {
        this.diagnosis = diagnosis;
        this.doctorId = doctorId;
        this.isConfidential = isConfidential;
        this.notes = notes;
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

    public List<String> getNotes() {
        return notes;
    }

    public Boolean getConfidential() {
        return isConfidential;
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

    @Override
    public void displayInfo() {
        System.out.println("MedicalRecord{" +
                "diagnosis='" + diagnosis + '\'' +
                ", recordId=" + recordId +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", visitDate=" + visitDate +
                ", prescription='" + prescription + '\'' +
                ", notes=" + notes +
                ", isConfidential=" + isConfidential +
                '}');
    }


    @Override
    public String displaySummary() {
        return "";
    }

    // appendNote
    public void appendNote(String note){
        notes.add(note);
    }

    //markConfidential()

       public void markConfidential() {
           isConfidential = true;
       }

       public boolean isConfidential(){
        return isConfidential;
       }










}
