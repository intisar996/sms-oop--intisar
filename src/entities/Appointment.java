package entities;

import java.sql.Time;
import java.util.Date;

public class Appointment {

    private Long appointmentId;
    private Long patientId;
    private Long doctorId;
    private Date appointmentDate;
    private Time appointmentTime;
    private String status;
    private String reason;
    private Boolean isFollowUp;


    public Appointment(Date appointmentDate, Long appointmentId, Long doctorId, Time appointmentTime, Boolean isFollowUp, Long patientId, String reason, String status) {
        this.appointmentDate = appointmentDate;
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.appointmentTime = appointmentTime;
        this.isFollowUp = isFollowUp;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
