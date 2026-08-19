package services;

import entities.Patient;
import interfaces.Manageable;

import java.util.ArrayList;
import java.util.List;

public class PatientService implements Manageable<Patient> {


     static List<Patient> patientList = new ArrayList<>();


    public Patient addPatient(Long id, String name, String lastname) {
        Patient patient = new Patient(id, name, lastname);
         patientList.add(patient);
         return patient;
    }

    public Patient addPatient(Long id, String name, String lastname, String bloodGroup) {
        Patient patient = new Patient(id,name,lastname,bloodGroup);
         patientList.add(patient);
         return patient;
    }


    public Patient addPatient(Patient patient) {
         patientList.add(patient);
        return patient;

    }


    public void add(Patient patient) {
        patientList.add(patient);

    }













    public void menuReslover(Integer option) {
        if(option.equals(1)){
            IO.println("add Patient");
            Long id = Long.parseLong(IO.readln("enter id"));
            String firstName = IO.readln("Enter first name");
            String lastName = IO.readln("Enter Last name");
            String bloodType = IO.readln("Enter BloodType");
            if(bloodType.trim().isEmpty()){
                addPatient(id,firstName,lastName);

            }else {
                addPatient(id,firstName,lastName,bloodType);

            }
        }
    }

}
