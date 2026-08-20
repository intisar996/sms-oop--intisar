package services;

import entities.Patient;
import interfaces.Manageable;
import interfaces.Searchable;
import utils.HelperUtils;
import utils.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class PatientService implements Manageable, Searchable {


     private Patient[] patients;
     private int count;



    public PatientService() {
        patients = new Patient[50];
        count = 0;
    }

  // overloading :three ways to add to patient
    public Patient addPatient(String firstName, String lastname,Integer age) {
        Long pid = HelperUtils.generateId();
        Patient patient = new Patient(pid, firstName, lastname,age);
        patient.displayInfo();
        add(patient);
         return patient;
    }

    public Patient addPatient(String name, String lastname, String bloodGroup,Integer age) {
        Long pid = HelperUtils.generateId();
        Patient patient = new Patient(pid,name,lastname,bloodGroup,age);
        add(patient);
         return patient;
    }


    public Patient addPatient(Patient patient) {
         add(patient);
        return patient;

    }

     //Manageable
    public void add(Object item) {
        if (item == null || !(item instanceof Patient)) {
            System.out.println("Rejected: not a Patient.");
            return;
        }
        if (count >= patients.length) {
            System.out.println("Rejected: Patient store is full.");
            return;
        }
        patients[count] = (Patient) item;
        count = count + 1;
    }

    @Override
    public Object[] getAll() {
        Object[] result = new Object[count];
        for(int i =0; i< count; i++){
            result[i] = patients[i];
        }
        return result;
    }


    // Search Services
    @Override
    public Object searchById(Long id) {
        for (int i = 0; i < count; i++) {
            if (patients[i].getId().equals(id)) {
                return patients[i];
            }
        }
        return null;
    }
    // ---------- service-specific ----------

    public void updateContact(Long id,String phone,String email) {
        Object found = searchById(id);
         if(found == null) {
             System.out.println("No patient with id " + id);
             return;
         }
        Patient p = (Patient) found;
        p.updateContact(phone, email);
    }

      public int getCount(){
        return count;
      }


}
