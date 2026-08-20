package entities;

import utils.HelperUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Doctor extends  Person {


    private String specialization;
    private Integer experienceYears;
    private Double consultationFee;
    private List<String> timesSlots;
    private List<Long> assignedPatientIds;
    private boolean isOnCall;
    private String reason;

    public Doctor(boolean active_status, String address, Integer age, Date dateOfBirth, String email, String firstName, String gender, long id, String lastName, String nationalId, String phoneNumber, List<Long> assignedPatientIds, Double consultationFee, Integer experienceYears, boolean isOnCall, String specialization, List<String> timesSlots) {
        super(active_status, address, age, dateOfBirth, email, firstName, gender, id, lastName, nationalId, phoneNumber);
        this.assignedPatientIds = assignedPatientIds;
        setConsultationFee(consultationFee);
        setExperienceYears(experienceYears);
        this.isOnCall = isOnCall;
        this.specialization = specialization;
        this.timesSlots = timesSlots;
    }

    public Doctor(long id, String firstName, String lastName,
                  Double consultationFee, Integer experienceYears,
                  Boolean isOnCall, String specialization) {

        super(id, firstName, lastName);

        this.timesSlots = new ArrayList<>();
        this.assignedPatientIds = new ArrayList<>();

        setConsultationFee(consultationFee);
        setExperienceYears(experienceYears);
        setOnCall(isOnCall);
        setSpecialization(specialization);
    }


    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<Long> getAssignedPatientIds() {
        return assignedPatientIds;
    }



    public Double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(Double consultationFee) {
        if(!HelperUtils.isValidAmount(consultationFee)){
            System.out.println("consultation fee must not be negative");
            return;
        }
        this.consultationFee = consultationFee;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        if(!HelperUtils.isValidNumber(experienceYears)){
            System.out.println("Experience years cannot be negative");
            return;
        }
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
        if(HelperUtils.isEmptyString(specialization)){
            System.out.println("specialization  is required");
            return;
        }
        this.specialization = specialization;
    }

    public List<String> getTimesSlots() {
        return timesSlots;
    }


    @Override
    public void displayInfo() {

        System.out.println("Doctor{" +
                "specialization='" + specialization + '\'' +
                ", experienceYears=" + experienceYears +
                ", consultationFee=" + consultationFee +
                ", timesSlots=" + timesSlots +
                ", assignedPatientIds=" + assignedPatientIds +
                ", isOnCall=" + isOnCall +
                ", reason='" + reason + '\'' +
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

    public void assignPatient(Long id) {
        if (!HelperUtils.isValidId(id)) {
            System.out.println("Invalid patient ID");
            return;
        }

        assignedPatientIds.add(id);
    }


     public int getPatientLoad(){
        return assignedPatientIds.size();
     }


   //fee methods

    public Double raiseFee(double amount) {
        if (!HelperUtils.isValidAmount(amount)) {
            System.out.println("Amount must not be negative");
            return consultationFee;
        }

        consultationFee += amount;
        return consultationFee;
    }



    // overLoading
    public void updateFee(Double fee){
        setConsultationFee(fee);
    }

    public void updateFee(Double fee, String reason){
        setConsultationFee(fee);
        setReason(reason);
    }















}
