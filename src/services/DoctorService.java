package services;

import entities.Doctor;
import entities.Patient;
import interfaces.Manageable;
import interfaces.Searchable;
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

    // Search Services
    @Override
    public Object searchById(Long id) {
        for (int i = 0; i < count; i++) {
            if (doctors[i].getId().equals(id)) {
                return doctors[i];
            }
        }
        return null;
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


    public int getCount(){
        return count;
    }


}
