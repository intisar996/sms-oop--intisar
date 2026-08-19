package entities;

import utils.HelperUtils;

import java.util.Date;
import java.util.List;

public class InPatient extends Patient{

     private Date admissionDate;
     private Integer roomNumber;
     private Double  dailyCharges;
     private Integer daysAdmitted;
     private Boolean admissionState;


    public InPatient(Boolean active_status, String address, Integer age, Date dateOfBirth, String email, String firstName, String gender, long id, String lastName, String nationalId, String phoneNumber, List<String> allergies, String bloodGroup, String emergencyContact, Boolean isInsured, Double outstandingBalance, List<Integer> pastMedicalRecordIds, Date registrationDate, Date admissionDate, Integer roomNumber, Double dailyCharges, Integer daysAdmitted, Boolean admissionState) {
        super(active_status, address, age, dateOfBirth, email, firstName, gender, id, lastName, nationalId, phoneNumber, allergies, bloodGroup, emergencyContact, isInsured, outstandingBalance, pastMedicalRecordIds, registrationDate);
        setAdmissionDate(admissionDate);
        setRoomNumber(roomNumber);
        setDailyCharges(dailyCharges);
        setDaysAdmitted(daysAdmitted);
        this.admissionState = admissionState;

    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        if(!HelperUtils.isValidVisitDate(admissionDate)) {
            System.out.println("Invalid date");
            return;
        }
        this.admissionDate = admissionDate;
    }

    public double getDailyCharges() {
        return dailyCharges;
    }

    public void setDailyCharges(Double dailyCharges) {
        if (!HelperUtils.isValidAmount(dailyCharges)) {
            System.out.println("amount must not be negative");
            return;
        }
        this.dailyCharges = dailyCharges;
    }

    public Integer getDaysAdmitted() {
        return daysAdmitted;
    }

    public void setDaysAdmitted(Integer daysAdmitted) {
        if(!HelperUtils.isValidNumber(daysAdmitted)){
            System.out.println("days Admitted must not be negative");
            return;
        }
        this.daysAdmitted = daysAdmitted;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        if(!HelperUtils.isValidNumber(roomNumber)){
            System.out.println("room Number must not be negative");
            return;
        }
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

       public void  discharge() {
        admissionState = false;
        this.admissionDate = null;

       }



       public Double totalRoomCost(){
          return dailyCharges * daysAdmitted;
       }







}
