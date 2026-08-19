package entities;

import java.util.Date;
import java.util.List;

public class InPatient extends Patient{

     private Date admissionDate;
     private Integer roomNumber;
     private double dailyCharges;
     private Integer daysAdmitted;
     private Boolean admissionState;


    public InPatient(boolean active_status, String address, Integer age, Date dateOfBirth, String email, String firstName, String gender, long id, String lastName, String nationalId, String phoneNumber, List<String> allergies, String bloodGroup, String emergencyContact, Boolean isInsured, Double outstandingBalance, List<Integer> pastMedicalRecordIds, Date registrationDate, Date admissionDate, double dailyCharges, Integer daysAdmitted, Integer roomNumber) {
        super(active_status, address, age, dateOfBirth, email, firstName, gender, id, lastName, nationalId, phoneNumber, allergies, bloodGroup, emergencyContact, isInsured, outstandingBalance, pastMedicalRecordIds, registrationDate);
        this.admissionDate = admissionDate;
        this.dailyCharges = dailyCharges;
        this.daysAdmitted = daysAdmitted;
        this.roomNumber = roomNumber;
    }

    public InPatient(long id, String firstName, String lastName, List<String> allergies, String bloodGroup, String emergencyContact, Boolean isInsured, Double outstandingBalance, List<Integer> pastMedicalRecordIds, Date registrationDate, Date admissionDate, double dailyCharges, Integer daysAdmitted, Integer roomNumber) {
        super(id, firstName, lastName, allergies, bloodGroup, emergencyContact, isInsured, outstandingBalance, pastMedicalRecordIds, registrationDate);
        this.admissionDate = admissionDate;
        this.dailyCharges = dailyCharges;
        this.daysAdmitted = daysAdmitted;
        this.roomNumber = roomNumber;
    }


    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public double getDailyCharges() {
        return dailyCharges;
    }

    public void setDailyCharges(double dailyCharges) {
        this.dailyCharges = dailyCharges;
    }

    public Integer getDaysAdmitted() {
        return daysAdmitted;
    }

    public void setDaysAdmitted(Integer daysAdmitted) {
        this.daysAdmitted = daysAdmitted;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Boolean getAdmissionState() {
        return admissionState;
    }

    // overload and display Info
    @Override
    public void displayInfo() {
        System.out.println("InPatient{" +
                "admissionDate=" + admissionDate +
                ", roomNumber=" + roomNumber +
                ", dailyCharges=" + dailyCharges +
                ", daysAdmitted=" + daysAdmitted +
                '}');
    }



      // admit
       public void admit(){
               admissionState = true;
              this.admissionDate = new Date();
       }

       // TODO check this
       public void  discharge() {
            admissionState = false;
       }



       public Double totalRoomCost(){
          return dailyCharges * daysAdmitted;
       }







}
