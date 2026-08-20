package services;

import entities.Nurse;
import entities.Patient;
import interfaces.Manageable;
import interfaces.Searchable;
import utils.HelperUtils;

public class NurseService implements Manageable, Searchable {


    private Nurse[] nurses;
    private int count;



    public NurseService() {
        nurses = new Nurse[60];
        count = 0;
    }


    public int getCount(){
        return count;
    }


    public Nurse addNurse(String firstName, String lastName, Long  departmentId, Integer yearsOfService,Integer age) {
        Long pid = HelperUtils.generateId();
        Nurse nurse = new Nurse(pid,firstName,lastName,age,departmentId,yearsOfService);
        add(nurse);
        return nurse;
    }
    // Manageable
    public void add(Object item) {
        if (item == null || !(item instanceof Nurse)) {
            System.out.println("Rejected: not a Nurse.");
            return;
        }
        if (count >= nurses.length) {
            System.out.println("Rejected: Nurse store is full.");
            return;
        }
        nurses[count] = (Nurse) item;
        count = count + 1;
    }

    @Override
    public Object[] getAll() {
        return new Object[0];
    }

    @Override
    public boolean removeById(Long id) {
        int found = -1;
        for (int i = 0; i < count; i++) {
            if (nurses[i].getId().equals(id)) {
                found = i;
                break;
            }
        }
        if (found == -1) {
            return false;
        }
        for (int i = found; i < count - 1; i++) {
            nurses[i] = nurses[i + 1];
        }
        nurses[count - 1] = null;
        count = count - 1;
        return true;

    }



    //--------------------------------------------------------
    private boolean matchesKeyword(Nurse n, String keyword) {
        if (HelperUtils.isEmptyString(keyword)) {
            return false;
        }
        String k = keyword.toLowerCase();
        return n.getFullName().toLowerCase().contains(k);
    }
    // Search Services
    @Override
    public Object searchById(Long id) {
        for (int i = 0; i < count; i++) {
            if (nurses[i].getId().equals(id)) {
                return nurses[i];
            }
        }
        return null;
    }

    @Override
    public Object[] search(String keyword) {

        int matches = 0;
        for (int i = 0; i < count; i++) {
            if (matchesKeyword(nurses[i], keyword)) {
                matches = matches + 1;
            }
        }
        Object[] result = new Object[matches];
        int pos = 0;
        for (int i = 0; i < count; i++) {
            if (matchesKeyword(nurses[i], keyword)) {
                result[pos] = nurses[i];
                pos = pos + 1;
            }
        }
        return result;
    }
}
