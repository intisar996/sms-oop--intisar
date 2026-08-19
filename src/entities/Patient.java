package entities;

import java.util.Date;
import java.util.List;

public class Patient extends  Person{



    private String bloodGroup;
    private String emergencyContact;
    private Date registrationDate;
    private List<String> allergies;
    private List<String>  pastMedicalRecordIds;
    private Double outstandingBalance;
    private Boolean isInsured;


    public Patient(boolean active_status, String address, Integer age, Date dateOfBirth, String email, String firstName, String gender, long id, String lastName, String nationalId, String phoneNumber, List<String> allergies, String bloodGroup, String emergencyContact, Boolean isInsured, Double outstandingBalance, List<String> pastMedicalRecordIds, Date registrationDate) {
        super(active_status, address, age, dateOfBirth, email, firstName, gender, id, lastName, nationalId, phoneNumber);
        this.allergies = allergies;
        this.bloodGroup = bloodGroup;
        this.emergencyContact = emergencyContact;
        this.isInsured = isInsured;
        this.outstandingBalance = outstandingBalance;
        this.pastMedicalRecordIds = pastMedicalRecordIds;
        this.registrationDate = registrationDate;
    }

    public Patient(long id, String firstName, String lastName, List<String> allergies, String bloodGroup, String emergencyContact, Boolean isInsured, Double outstandingBalance, List<String> pastMedicalRecordIds, Date registrationDate) {
        super(id, firstName, lastName);
        this.allergies = allergies;
        this.bloodGroup = bloodGroup;
        this.emergencyContact = emergencyContact;
        this.isInsured = isInsured;
        this.outstandingBalance = outstandingBalance;
        this.pastMedicalRecordIds = pastMedicalRecordIds;
        this.registrationDate = registrationDate;
    }



  // overload and display Info
    @Override
    public void displayInfo() {
        System.out.println("Patient{" +
                "allergies=" + allergies +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", registrationDate=" + registrationDate +
                ", pastMedicalRecordIds=" + pastMedicalRecordIds +
                ", outstandingBalance=" + outstandingBalance +
                ", isInsured=" + isInsured +
                '}');
    }


     // add allergy to list
     public void addAllergy(String allergy ){
             allergies.add(allergy);
     }

     // check if patient hasAllergy
    public boolean hasAllergy(){
        return !allergies.isEmpty();
    }






}
