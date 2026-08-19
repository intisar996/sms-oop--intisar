package entities;

import interfaces.Displayable;
import utils.HelperUtils;

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
         setDiagnosis(diagnosis);
        setDoctorId(doctorId);
        this.isConfidential = isConfidential;
        setNotes(notes);
        setPatientId(patientId);
        setPrescription(prescription);
        setRecordId(recordId);
        setVisitDate(visitDate);
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        if (HelperUtils.isEmptyString(diagnosis)) {
            System.out.println("Diagnosis is required");
            return;
        }
        this.diagnosis = diagnosis;
    }


    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        if(!HelperUtils.isValidId(doctorId)) {
            System.out.println("Doctor id is required");
            return;
        }
        this.doctorId = doctorId;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        if (notes == null) {
            System.out.println("Notes list cannot be null");
            return;
        }
        this.notes = notes;
    }


    public Boolean getConfidential() {
        return isConfidential;
    }

    public void setConfidential(Boolean confidential) {
        if (confidential == null) {
            System.out.println("Confidential status is required");
            return;
        }
        isConfidential = confidential;
    }


    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        if (HelperUtils.isEmptyString(prescription)) {
            System.out.println("Prescription is required");
            return;
        }
        this.prescription = prescription;
    }


    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        if(!HelperUtils.isValidId(patientId)) {
            System.out.println("patient id is required");
            return;
        }
        this.patientId = patientId;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        if(!HelperUtils.isValidId(recordId)) {
            System.out.println("record id is required");
            return;
        }
        this.recordId = recordId;

    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        if (!HelperUtils.isValidVisitDate(visitDate)) {
            System.out.println("Invalid visit date");
            return;
        }
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
    public void appendNote(String note) {
        if (HelperUtils.isEmptyString(note)) {
            System.out.println("Note is required");
            return;
        }

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
