package services;

import entities.Doctor;
import entities.InPatient;
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

    @Override
    public boolean removeById(Long id) {
        int found = -1;
        for (int i = 0; i < count; i++) {
            if (patients[i].getId().equals(id)) {
                found = i;
                break;
            }
        }
        if (found == -1) {
            return false;
        }
        for (int i = found; i < count - 1; i++) {
            patients[i] = patients[i + 1];
        }
        patients[count - 1] = null;
        count = count - 1;
        return true;

    }
   //--------------------------------------------------------
   private boolean matchesKeyword(Patient p, String keyword) {
       if (HelperUtils.isEmptyString(keyword)) {
           return false;
       }
       String k = keyword.toLowerCase();
       return p.getFullName().toLowerCase().contains(k);
   }

    // Search Services
    @Override
    public Patient searchById(Long id) {
        for (int i = 0; i < count; i++) {
            if (patients[i].getId().equals(id)) {
                return patients[i];
            }
        }
        return null;
    }

    @Override
    public Object[] search(String keyword) {

        int matches = 0;
        for (int i = 0; i < count; i++) {
            if (matchesKeyword(patients[i], keyword)) {
                matches = matches + 1;
            }
        }
        Object[] result = new Object[matches];
        int pos = 0;
        for (int i = 0; i < count; i++) {
            if (matchesKeyword(patients[i], keyword)) {
                result[pos] = patients[i];
                pos = pos + 1;
            }
        }
        return result;
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




    public Object[] listInPatients() {
        int matches = 0;

        for (int i = 0; i < count; i++) {
            if (patients[i] instanceof InPatient) {
                InPatient p = (InPatient) patients[i];

                if (Boolean.TRUE.equals(p.getAdmissionState())) {
                    matches++;
                }
            }
        }

        // Create result array
        Object[] result = new Object[matches];
        int pos = 0;

        for (int i = 0; i < count; i++) {
            if (patients[i] instanceof InPatient) {
                InPatient p = (InPatient) patients[i];

                if (Boolean.TRUE.equals(p.getAdmissionState())) {
                    result[pos] = p;
                    pos++;
                }
            }
        }

        return result;
    }

    public double totalOutstanding() {
        double total = 0.0;

        for (int i = 0; i < count; i++) {
            if (patients[i] != null) {
                total += patients[i].getOutstandingBalance();
            }
        }

        return total;
    }


}






