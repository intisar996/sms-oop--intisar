package services;

import entities.Nurse;
import entities.Patient;

public class NurseService {


    private Nurse[] nurses;
    private int count;



    public NurseService() {
        nurses = new Nurse[60];
        count = 0;
    }

    public int getCount(){
        return count;
    }
}
