package entities;

import interfaces.Displayable;

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
        complete,
        cancel
    }

    public Appointment(Date appointmentDate, Long appointmentId, Time appointmentTime, Boolean isFollowUp, Long doctorId, Long patientId, String reason, Status status) {
        this.appointmentDate = appointmentDate;
        this.appointmentId = appointmentId;
        this.appointmentTime = appointmentTime;
        this.isFollowUp = isFollowUp;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.reason = reason;
        this.status = status;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Time getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Time appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
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
        this.patientId = patientId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Status getStatus() {
        return status;
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
        return "";
    }



    // change status

    public void cancel(){
        status = Status.cancel;
    }


    public void complete(){
        status = Status.complete;
    }






}
