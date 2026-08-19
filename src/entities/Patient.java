package entities;

import utils.HelperUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Patient extends  Person{



    private String bloodGroup;
    private String emergencyContact;
    private Date registrationDate;
    private List<String> allergies;
    private List<Integer>  pastMedicalRecordIds;
    private Double outstandingBalance;
    private Boolean isInsured;


    public Patient(boolean active_status, String address, Integer age,
                   Date dateOfBirth, String email, String firstName,
                   String gender, Long id, String lastName,
                   String nationalId, String phoneNumber,
                   List<String> allergies, String bloodGroup,
                   String emergencyContact, Boolean isInsured,
                   Double outstandingBalance,
                   List<Integer> pastMedicalRecordIds,
                   Date registrationDate) {

        super(active_status, address, age, dateOfBirth, email, firstName,
                gender, id, lastName, nationalId, phoneNumber);

        this.allergies = new ArrayList<>();
        this.pastMedicalRecordIds = new ArrayList<>();
        setBloodGroup(bloodGroup);
        setEmergencyContact(emergencyContact);
        setInsured(isInsured);
        setOutstandingBalance(outstandingBalance);
        setRegistrationDate(registrationDate);

    }

    public Patient(Long id, String firstName, String lastName, String bloodGroup) {
        super(id, firstName, lastName);

        this.allergies = new ArrayList<>();
        this.pastMedicalRecordIds = new ArrayList<>();
        setOutstandingBalance(outstandingBalance);
        setInsured(isInsured);
        setRegistrationDate(registrationDate);

        setBloodGroup(bloodGroup);
    }



    public Patient(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);

        setAllergies(allergies);
        this.pastMedicalRecordIds = new ArrayList<>();
        setOutstandingBalance(outstandingBalance);
        setInsured(isInsured);
        setRegistrationDate(registrationDate);
    }


    // overload and display Info
  @Override
  public void displayInfo() {
      super.displayInfo();

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



    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {

        this.allergies = allergies;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        if(HelperUtils.isEmptyString(bloodGroup)){
            System.out.println("bloodGroup  is required");
            return;
        }
        this.bloodGroup = bloodGroup;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        if(!HelperUtils.isValidPhone(emergencyContact)){
            System.out.println("emergencyContact  is required");
            return;
        }
        this.emergencyContact = emergencyContact;
    }

    public Boolean getInsured() {
        return isInsured;
    }

    public void setInsured(Boolean insured) {
        isInsured = insured;
    }

    public Double getOutstandingBalance() {
        return outstandingBalance;
    }

    public void setOutstandingBalance(Double outstandingBalance) {
        if(!HelperUtils.isValidAmount(outstandingBalance)){
            System.out.println("consultation fee must not be negative");
            return;
        }
        this.outstandingBalance = outstandingBalance;
    }

    public List<Integer> getPastMedicalRecordIds() {
        return pastMedicalRecordIds;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    // add allergy to list
     public void addAllergy(String allergy ){
         if (HelperUtils.isEmptyString(allergy)) {
             System.out.println("Allergy is required");
             return;
         }
             allergies.add(allergy);
     }

     // check if patient hasAllergy
    public boolean hasAllergy(String allergy){
        return allergies.contains(allergy);
    }

    public void listAllergies() {
        for (String allergy : allergies) {
            System.out.println(allergy);
        }
    }


    //Patient record + balance methods   [Task 1.2]

    // add patient record id to list
    public void addRecordId(Integer recordId){
        pastMedicalRecordIds.add(recordId);
    }

    // count patient record
    public int getRecordCount(){
        return pastMedicalRecordIds.size();
    }


    // add to balance

    public double addToBalance(double amount){
        if(HelperUtils.isValidAmount(amount)){
            return outstandingBalance += amount;
        }
        System.out.println("Balance must not be negative");
          return  outstandingBalance;
    }

    // clear balance
    public void  clearBalance(){
        outstandingBalance = 0.0;
    }




}
