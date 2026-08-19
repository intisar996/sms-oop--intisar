package entities;

import utils.HelperUtils;

import java.util.Date;
import java.util.List;

public class Doctor extends  Person {


    private String specialization;
    private Integer experienceYears;
    private Double consultationFee;
    private List<String> timesSlots;
    private List<Long> assignedPatientIds;
    private boolean isOnCall;

    public Doctor(boolean active_status, String address, Integer age, Date dateOfBirth, String email, String firstName, String gender, long id, String lastName, String nationalId, String phoneNumber, List<Long> assignedPatientIds, Double consultationFee, Integer experienceYears, boolean isOnCall, String specialization, List<String> timesSlots) {
        super(active_status, address, age, dateOfBirth, email, firstName, gender, id, lastName, nationalId, phoneNumber);
        this.assignedPatientIds = assignedPatientIds;
        this.consultationFee = consultationFee;
        this.experienceYears = experienceYears;
        this.isOnCall = isOnCall;
        this.specialization = specialization;
        this.timesSlots = timesSlots;
    }

    public Doctor(long id, String firstName, String lastName, List<Long> assignedPatientIds, Double consultationFee, Integer experienceYears, boolean isOnCall, String specialization, List<String> timesSlots) {
        super(id, firstName, lastName);
        this.assignedPatientIds = assignedPatientIds;
        this.consultationFee = consultationFee;
        this.experienceYears = experienceYears;
        this.isOnCall = isOnCall;
        this.specialization = specialization;
        this.timesSlots = timesSlots;
    }


    public List<Long> getAssignedPatientIds() {
        return assignedPatientIds;
    }



    public Double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(Double consultationFee) {
        if(HelperUtils.isValidAmount(consultationFee)){
            System.out.println("consultation fee must not be negative");
        }
        this.consultationFee = consultationFee;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public boolean isOnCall() {
        return isOnCall;
    }

    public void setOnCall(boolean onCall) {
        isOnCall = onCall;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<String> getTimesSlots() {
        return timesSlots;
    }


    @Override
    public void displayInfo() {

        System.out.println("Doctor{" +
                "assignedPatientIds=" + assignedPatientIds +
                ", specialization='" + specialization + '\'' +
                ", experienceYears=" + experienceYears +
                ", consultationFee=" + consultationFee +
                ", timesSlots=" + timesSlots +
                ", isOnCall=" + isOnCall +
                '}');
    }


    public void addSlot(String slot) {
        timesSlots.add(slot);
    }

    public void removeSlot(String slot) {
                timesSlots.remove(slot);
    }

    public boolean hasSlot(String slot) {
        return timesSlots.contains(slot);
    }
    // assign patient

    public void assignPatient(Long id){
        if(id > 0 ){
            assignedPatientIds.add(id);
        }

    }



      // TODO : check this later
     public int getPatientLoad(){
        return assignedPatientIds.size();
     }


   //fee methods

      public Double raiseFee(double amount){
        if(amount < 0 ) {
            System.out.println("amount not must be negative");
             return consultationFee;
        }else {
            return consultationFee += amount;
        }
      }












}
