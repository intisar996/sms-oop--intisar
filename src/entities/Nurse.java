package entities;

import entities.Person;
import utils.HelperUtils;

import java.security.PrivateKey;
import java.util.Date;
import java.util.List;

public class Nurse extends Person {


    private Long  departmentId;
    private Shift shift;
    private List<Long>  assignedPatientIds;
    private Integer yearsOfService;

    public enum Shift{
        MORNING,
        EVENING,
        NIGHT
    }


    public Nurse(boolean active_status, String address, Integer age, Date dateOfBirth, String email, String firstName, String gender, long id, String lastName, String nationalId, String phoneNumber, List<Long> assignedPatientIds, Long  departmentId, Shift shift, Integer yearsOfService) {
        super(active_status, address, age, dateOfBirth, email, firstName, gender, id, lastName, nationalId, phoneNumber);
        this.assignedPatientIds = assignedPatientIds;
        setDepartmentId(departmentId);
        this.shift = shift;
        setYearsOfService(yearsOfService);
    }

    public Nurse(long id, String firstName, String lastName, List<Long> assignedPatientIds, Long  departmentId, Shift shift, Integer yearsOfService) {
        super(id, firstName, lastName);
        this.assignedPatientIds = assignedPatientIds;
        this.departmentId = departmentId;
        this.shift = shift;
        setYearsOfService(yearsOfService);
    }


    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
         if(!HelperUtils.isValidId(departmentId)){
             System.out.println("Invalid department Id");
             return;
         }
        this.departmentId = departmentId;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
       if(shift == null){
           System.out.println("Shift is required");
           return;
       }
        this.shift = shift;
    }

    public List<Long> getAssignedPatientIds() {
        return assignedPatientIds;
    }

    public void setAssignedPatientIds(List<Long> assignedPatientIds) {
        this.assignedPatientIds = assignedPatientIds;
    }

    public Integer getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(Integer yearsOfService) {
       if(!HelperUtils.isValidNumber(yearsOfService)){
           System.out.println("Years of service cannot be negative ");
           return;
       }
        this.yearsOfService = yearsOfService;
    }

    @Override
    public void displayInfo() {
        System.out.println("Nurse{" +
                "assignedPatientIds=" + assignedPatientIds +
                ", departmentId=" + departmentId +
                ", shift=" + shift +
                ", yearsOfService=" + yearsOfService +
                '}');
    }

      // assign patient

    public void assignPatient(long id){
        if(HelperUtils.isValidId(id)){
            assignedPatientIds.add(id);
        }
    }

    //unassignPatient
    public void unassignPatient(long id){
        assignedPatientIds.remove(id);
    }


    public int getPatientLoad(){
        return assignedPatientIds.size();
    }


     //isNightShift
    public boolean isNightShift(){
        return this.shift == Shift.NIGHT;
    }






}
