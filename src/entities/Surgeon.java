package entities;

import utils.HelperUtils;

import java.util.Date;
import java.util.List;

public class Surgeon extends  Doctor{


    private Integer surgeriesPerformed;
    private Boolean operationTheatreAccess;
    private List<Date> upcomingSurgeryDates;

    public Surgeon(boolean active_status, String address, Integer age, Date dateOfBirth, String email, String firstName, String gender, long id, String lastName, String nationalId, String phoneNumber, List<Long> assignedPatientIds, Double consultationFee, Integer experienceYears, boolean isOnCall, String specialization, List<String> timesSlots, Boolean operationTheatreAccess) {
        super(active_status, address, age, dateOfBirth, email, firstName, gender, id, lastName, nationalId, phoneNumber, assignedPatientIds, consultationFee, experienceYears, isOnCall, specialization, timesSlots);
        setSurgeriesPerformed(surgeriesPerformed);
        setOperationTheatreAccess(operationTheatreAccess);
        setUpcomingSurgeryDates(upcomingSurgeryDates);
    }

    public Surgeon(long id, String firstName, String lastName, Double consultationFee, Integer experienceYears, Boolean isOnCall, String specialization, Boolean operationTheatreAccess) {
        super(id, firstName, lastName,experienceYears, consultationFee, isOnCall, specialization);
        setSurgeriesPerformed(surgeriesPerformed);
        setOperationTheatreAccess(operationTheatreAccess);
        setUpcomingSurgeryDates(upcomingSurgeryDates);
    }

    public Integer getSurgeriesPerformed() {
        return surgeriesPerformed;
    }

    public void setSurgeriesPerformed(Integer surgeriesPerformed) {
    if(!HelperUtils.isValidNumber(surgeriesPerformed)){
        System.out.println("surgeriesPerformed must not be negative");
        return;
    }
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

        if (!HelperUtils.isValidDate(date)) {
            System.out.println("Invalid surgery date");
            return;
        }

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
