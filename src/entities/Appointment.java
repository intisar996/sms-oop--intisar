package entities;

import interfaces.Displayable;
import utils.HelperUtils;

import java.sql.Time;
import java.util.Date;

public class Appointment implements Displayable {

    private Long appointmentId;
    private Long patientId;
    private Long doctorId;
    private Date appointmentDate;
    private Time appointmentTime;
    private Status status;
    private String reason;
    private Boolean isFollowUp;

    public enum  Status {
        COMPLETE,
        CANCEL,
        RESCHEDULE,
        SCHEDULE

    }

    public Appointment(Date appointmentDate, Long appointmentId, Time appointmentTime, Boolean isFollowUp, Long doctorId, Long patientId, String reason, Status status) {
        setAppointmentDate(appointmentDate);
        setAppointmentId(appointmentId);
        setAppointmentTime(appointmentTime);
        setFollowUp(isFollowUp);
        setDoctorId(doctorId);
        setPatientId(patientId);
        setReason(reason);
        setStatus(status);
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        if (!HelperUtils.isValidDate(appointmentDate)) {
            System.out.println("Invalid appointment Date ");
            return;
        }
        this.appointmentDate = appointmentDate;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        if (!HelperUtils.isValidId(appointmentId)) {
            System.out.println("Invalid appointment ID");
            return;
        }
        this.appointmentId = appointmentId;
    }

    public Time getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Time appointmentTime) {
        if (appointmentTime == null) {
            System.out.println("Appointment time is required");
            return;
        }
        this.appointmentTime = appointmentTime;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        if (!HelperUtils.isValidId(doctorId)) {
            System.out.println("Invalid doctor ID");
            return;
        }
        this.doctorId = doctorId;
    }

    public Boolean getFollowUp() {
        return isFollowUp;
    }

    public void setFollowUp(Boolean followUp) {
        isFollowUp = followUp;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        if (!HelperUtils.isValidId(patientId)) {
            System.out.println("Invalid patient ID");
            return;
        }
        this.patientId = patientId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        if (HelperUtils.isEmptyString(reason)) {
            System.out.println("Reason is required");
            return;
        }
        this.reason = reason;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (status == null) {
            System.out.println("Invalid status");
            return;
        }

        this.status = status;
    }


    @Override
    public void displayInfo() {
        System.out.println("Appointment{" +
                "appointmentDate=" + appointmentDate +
                ", appointmentId=" + appointmentId +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", appointmentTime=" + appointmentTime +
                ", status='" + status + '\'' +
                ", reason='" + reason + '\'' +
                ", isFollowUp=" + isFollowUp +
                '}');
    }


    @Override
    public String displaySummary() {
        return appointmentId + " | Patient: " + patientId +
                " | Doctor: " + doctorId +
                " | Date: " + appointmentDate;
    }



    // change status

    public void cancel(){
        status = Status.CANCEL;
    }


    public void complete(){
        status = Status.COMPLETE;
    }

    public void reschedule(Date date, Time time){
        appointmentDate =date;
        appointmentTime = time;
        this.status = Status.RESCHEDULE;
    }


    public boolean isPast(Date date) {
        return appointmentDate.compareTo(date) < 0;
    }



    // addNotes overloads   [Task 2.2]

// ---------- add notes to reason (2 overloads) ----------

    // notes only
    public void addNotes(String notes) {
        if (HelperUtils.isEmptyString(notes)) {
            return;
        }
        if (HelperUtils.isEmptyString(reason)) {
            reason = notes;
        } else {
            reason = reason + " | " + notes;
        }
    }

    // notes with an author
    public void addNotes(String notes, String author) {
        addNotes("(" + author + ") " + notes);
    }






}
