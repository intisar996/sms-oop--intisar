package entities;

import java.util.Date;
import java.util.List;

public class Doctor extends  Person {



    private String  specialization;
    private Integer  experienceYears;
    private Double  consultationFee;
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


    












}
