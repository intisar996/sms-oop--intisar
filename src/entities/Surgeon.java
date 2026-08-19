package entities;

import java.util.Date;
import java.util.List;

public class Surgeon extends  Doctor{


    private Integer surgeriesPerformed;
    private Boolean operationTheatreAccess;
    private List<Date> upcomingSurgeryDates;

    public Surgeon(boolean active_status, String address, Integer age, Date dateOfBirth, String email, String firstName, String gender, long id, String lastName, String nationalId, String phoneNumber, List<Long> assignedPatientIds, Double consultationFee, Integer experienceYears, boolean isOnCall, String specialization, List<String> timesSlots, Integer surgeriesPerformed, Boolean operationTheatreAccess, List<Date> upcomingSurgeryDates) {
        super(active_status, address, age, dateOfBirth, email, firstName, gender, id, lastName, nationalId, phoneNumber, assignedPatientIds, consultationFee, experienceYears, isOnCall, specialization, timesSlots);
        this.surgeriesPerformed = surgeriesPerformed;
        this.operationTheatreAccess = operationTheatreAccess;
        this.upcomingSurgeryDates = upcomingSurgeryDates;
    }

    public Surgeon(long id, String firstName, String lastName, List<Long> assignedPatientIds, Double consultationFee, Integer experienceYears, boolean isOnCall, String specialization, List<String> timesSlots, Integer surgeriesPerformed, Boolean operationTheatreAccess, List<Date> upcomingSurgeryDates) {
        super(id, firstName, lastName, assignedPatientIds, consultationFee, experienceYears, isOnCall, specialization, timesSlots);
        this.surgeriesPerformed = surgeriesPerformed;
        this.operationTheatreAccess = operationTheatreAccess;
        this.upcomingSurgeryDates = upcomingSurgeryDates;
    }


    public Integer getSurgeriesPerformed() {
        return surgeriesPerformed;
    }

    public void setSurgeriesPerformed(Integer surgeriesPerformed) {
        this.surgeriesPerformed = surgeriesPerformed;
    }

    public Boolean getOperationTheatreAccess() {
        return operationTheatreAccess;
    }

    public void setOperationTheatreAccess(Boolean operationTheatreAccess) {
        this.operationTheatreAccess = operationTheatreAccess;
    }

    public List<Date> getUpcomingSurgeryDates() {
        return upcomingSurgeryDates;
    }

    public void setUpcomingSurgeryDates(List<Date> upcomingSurgeryDates) {
        this.upcomingSurgeryDates = upcomingSurgeryDates;
    }

    @Override
    public void displayInfo() {

        System.out.println(
                 "Surgeon{" +
                  "surgeriesPerformed=" + surgeriesPerformed +
                   ", operationTheatreAccess=" + operationTheatreAccess +
                   ", upcomingSurgeryDates=" + upcomingSurgeryDates +
                   '}');

    }




    public void performSurgery(){
     surgeriesPerformed++;

    }

    public void scheduleSurgery(Date date){
        if(upcomingSurgeryDates.contains(date)){
            System.out.println("no place in this date");
            return;
        }
        upcomingSurgeryDates.add(date);
    }

    public int getUpcomingCount(){
        return upcomingSurgeryDates.size();
    }









}
