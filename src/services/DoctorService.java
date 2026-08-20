package services;

import entities.Doctor;
import entities.Patient;
import interfaces.Manageable;
import utils.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class DoctorService implements Manageable<Doctor> {



    List<Doctor> doctorList = new ArrayList<>();


    @Override
    public void add(Doctor doctor) {
        doctorList.add(doctor);
    }

    @Override
    public Boolean update(Long id) {

        IO.readln("Enter Doctor ID");
        Long doid = InputHandler.takeLongInput();
        Doctor doctorUpdateFee = findDoctorById(doid);
        if(doctorUpdateFee != null){
            Double fee = Double.parseDouble(IO.readln("Enter consultation fee: "));
            String reason = (IO.readln("Enter Reason: "));
            doctorUpdateFee.updateFee(fee,reason);
            doctorUpdateFee.updateFee(fee);

        }




        return null;
    }









    // search patient by id
    public Doctor findDoctorById(Long id){
        for(Doctor d : doctorList){
            if(d.getId().equals(id)){
                return d;
            }
        }
        return null;
    }



    public void menuReslover(Integer option) {
        if(option.equals(1)){
            IO.println("add Doctor");
            Long id = Long.parseLong(IO.readln("enter id"));
            String firstName = IO.readln("Enter first name");
            String lastName = IO.readln("Enter Last name");
            Double fee = Double.parseDouble(IO.readln("Enter consultation fee: "));
            Integer experienceYears = Integer.parseInt(IO.readln("Enter experience years: "));
            Boolean isOnCall = Boolean.parseBoolean(IO.readln("Is doctor on call? true/false: "));
            String specialization = IO.readln("Enter specialization: ");
            Doctor doctor = new Doctor(id,firstName,lastName,fee,experienceYears,isOnCall,specialization);
            add(doctor);
            doctor.displayInfo();
            System.out.println("Successfully add doctor");
        } else if (option.equals(2)) {
            IO.println("Update Patient Contact");
            update(0l);
        }
    }
}
