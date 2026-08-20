package services;

import entities.Patient;
import interfaces.Manageable;
import utils.HelperUtils;
import utils.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class PatientService implements Manageable<Patient> {


     static List<Patient> patientList = new ArrayList<>();

  // overloading :three ways to add to patient
    public Patient addPatient(Long id, String name, String lastname) {

        Patient patient = new Patient(id, name, lastname);
        patient.displayInfo();
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

    @Override
    public Boolean update(Long id) {

        IO.println("Enter patient Id");
        Long pid = InputHandler.takeLongInput();
        Patient patientUpdateContact = findPatientById(pid);

        if(patientUpdateContact != null){
           String email = IO.readln("Enter new email");
           String phone = IO.readln("Enter new phone number");
            patientUpdateContact.updateContact(phone,email);
            System.out.println("Successfully Update contact");
            patientUpdateContact.displayInfo();
            return true;
        }

        return false;
    }







   // search patient by id
    public Patient findPatientById(Long id){
        for(Patient p : patientList){
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }






    public void menuReslover(Integer option) {
        if(option.equals(1)){
            IO.println("add Patient");
            Long id = Long.parseLong(IO.readln("enter id"));
            String firstName = IO.readln("Enter first name");
            String lastName = IO.readln("Enter Last name");
            addPatient(id,firstName,lastName);
           // String bloodType = IO.readln("Enter BloodType");
        } else if (option.equals(2)) {
            IO.println("Update Patient Contact");
            update(0l);
        }
    }

}
