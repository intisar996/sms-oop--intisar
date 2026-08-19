import entities.Person;
import utils.HelperUtils;

import java.security.PrivateKey;
import java.util.Date;
import java.util.List;

public class Nurse extends Person {


    private Integer departmentId;
    private Shift shift;
    private List<Long>  assignedPatientIds;
    private Integer yearsOfService;

    public enum Shift{
        Morning,
        Evening,
        Night
    }


    public Nurse(boolean active_status, String address, Integer age, Date dateOfBirth, String email, String firstName, String gender, long id, String lastName, String nationalId, String phoneNumber, List<Long> assignedPatientIds, Integer departmentId, Shift shift, Integer yearsOfService) {
        super(active_status, address, age, dateOfBirth, email, firstName, gender, id, lastName, nationalId, phoneNumber);
        this.assignedPatientIds = assignedPatientIds;
        this.departmentId = departmentId;
        this.shift = shift;
        this.yearsOfService = yearsOfService;
    }

    public Nurse(long id, String firstName, String lastName, List<Long> assignedPatientIds, Integer departmentId, Shift shift, Integer yearsOfService) {
        super(id, firstName, lastName);
        this.assignedPatientIds = assignedPatientIds;
        this.departmentId = departmentId;
        this.shift = shift;
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


    // TODO : check this later
    public int getPatientLoad(){
        return assignedPatientIds.size();
    }


     //isNightShift
    public boolean isNightShift(){
        return shift == Shift.Night;
    }






}
