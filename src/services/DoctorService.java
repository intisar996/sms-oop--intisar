package services;

import entities.Doctor;
import entities.Patient;
import entities.Surgeon;
import interfaces.Manageable;
import interfaces.Searchable;
import utils.HelperUtils;
import utils.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class DoctorService implements Manageable, Searchable {

    private Doctor[] doctors;
    private int count;

    public DoctorService() {
        doctors = new Doctor[20];
        count = 0;
    }




    // ---------- Manageable ----------
    @Override
    public void add(Object item) {
        if (item == null || !(item instanceof Doctor)) {
            System.out.println("Rejected: not a Doctor.");
            return;
        }
        if (count >= doctors.length) {
            System.out.println("Rejected: Doctor store is full.");
            return;
        }
        doctors[count] = (Doctor) item;
        count = count + 1;
    }

    @Override
    public Object[] getAll() {
        Object[] result = new Object[count];
        for(int i =0; i< count; i++){
            result[i] = doctors[i];
        }
        return result;
    }
    @Override
    public boolean removeById(Long id) {
        int found = -1;
        for (int i = 0; i < count; i++) {
            if (doctors[i].getId().equals(id)) {
                found = i;
                break;
            }
        }
        if (found == -1) {
            return false;
        }
        for (int i = found; i < count - 1; i++) {
            doctors[i] = doctors[i + 1];
        }
        doctors[count - 1] = null;
        count = count - 1;
        return true;

    }

    // Search Services
    @Override
    public Doctor searchById(Long id) {
        for (int i = 0; i < count; i++) {
            if (doctors[i].getId().equals(id)) {
                return doctors[i];
            }
        }
        return null;
    }
    //-------------------------------

    private boolean matchesKeyword(Doctor p, String keyword) {
        if (HelperUtils.isEmptyString(keyword)) {
            return false;
        }
        String k = keyword.toLowerCase();
        return p.getFullName().toLowerCase().contains(k);
    }


    @Override
    public Object[] search(String keyword) {

        int matches = 0;
        for (int i = 0; i < count; i++) {
            if (matchesKeyword(doctors[i], keyword)) {
                matches = matches + 1;
            }
        }
        Object[] result = new Object[matches];
        int pos = 0;
        for (int i = 0; i < count; i++) {
            if (matchesKeyword(doctors[i], keyword)) {
                result[pos] = doctors[i];
                pos = pos + 1;
            }
        }
        return result;
    }

    // ---------- service-specific ---------
    public void updateFee(Long id,double fee) {
        Object found = searchById(id);
        if (found == null) {
            System.out.println("No doctor with id " + id);
            return;
        }
        Doctor d = (Doctor) found;
        d.updateFee(fee);
    }

    public void assignPatient(Long id) {
        Object found = searchById(id);
        if (found == null) {
            System.out.println("No Patient with id " + id);
            return;
        }
        Doctor d = (Doctor) found;
        d.assignPatient(id);
    }

    public void addSurgeon(Surgeon surgeon) {
        if (count >= doctors.length) {
            System.out.println("Cannot add surgeon.  is full.");
            return;
        }
        doctors[count] = surgeon;
        count++;

        System.out.println("Surgeon added successfully.");
    }


    public void listBySpecialization(String specialization) {
        System.out.println("--- Doctor of " + specialization + " ---");
        boolean any = false;
        for (int i = 0; i < count; i++) {
            if (doctors[i].getSpecialization().equalsIgnoreCase(specialization)) {
                doctors[i].displaySummary();
                any = true;
            }
        }
        if (!any) {
            System.out.println("(none)");
        }
    }


    public void availableDoctors() {
        System.out.println("--- Available Doctors---");
        boolean any = false;
        for (int i = 0; i < count; i++) {
            if (doctors[i].getPatientLoad() < 5) {
                doctors[i].displaySummary();
                any = true;
            }
        }
        if (!any) {
            System.out.println("(none)");
        }
    }


    public int getCount(){
        return count;
    }


}
