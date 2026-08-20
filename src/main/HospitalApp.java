package main;

import entities.*;
import services.AppointmentService;
import services.DoctorService;
import services.NurseService;
import services.PatientService;
import utils.HelperUtils;
import utils.InputHandler;

public class HospitalApp {


    // services
    private PatientService patientService = new PatientService();
    private DoctorService doctorService = new DoctorService();
    private AppointmentService appointmentService = new AppointmentService();
    private NurseService nurseService = new NurseService();


    // read keyBord input
    private InputHandler input = new InputHandler();

    private void printEntities(Object[] items) {
        if (items.length == 0) {
            System.out.println("(nothing to show)");
            return;
        }
        for (int i = 0; i < items.length; i++) {
            interfaces.Displayable d = (interfaces.Displayable) items[i];
            d.displayInfo();
            System.out.println();
        }
    }


    // patient


    private void patientMenu() {
        System.out.println("*****Patient*****");
        System.out.println("1. Add   2. View all   3. Search   4. Update contact   5. Remove ");
        int choice = input.readInt("Choose", 1, 5);

        if (choice == 1) {
            String first = input.readText("First name");
            String last = input.readText("Last name");
            String bloodGroup = input.readText("Blood Group");
            Patient p = patientService.addPatient(first, last, bloodGroup);
            System.out.println("Added student with id " + p.getId());
        }

    }





    // reports

     private void reportMenu(){

         Person[] people = buildAllPerson();
         int count = people.length;
         System.out.println("\n[Counts by type]");
         countByType(people, count);


         System.out.println("\n[All people - polymorphic displayInfo]");
         printAll(people, count);

     }

    // Count By Type


    // count how many are of each type (most specific first)
    private void countByType(Person[] people, int count) {
        int patient = 0;
        int doctors = 0;
        int nurse = 0;
        for (int i = 0; i < count; i++) {
            Person p = people[i];
            if (p instanceof Patient) {
                patient = patient + 1;
            } else if (p instanceof Doctor) {
                doctors = doctors + 1;
            } else if (p instanceof Nurse) {
                nurse = nurse + 1;
            }
        }
        System.out.println("Patient : " + patient);
        System.out.println("Doctors : " + doctors);
        System.out.println("Nurse : " + nurse);
    }


      // polymorphism helpers

        private  Person[] buildAllPerson() {
        Object[] patients = patientService.getAll();
        Object[] doctors = doctorService.getAll();
        Person[] people = new Person[patients.length + doctors.length];
        int pos = 0;
        for(int i =0; i < patients.length;i++){
            people[pos] = (Person) patients[i];
            pos = pos +1;

        }
            for (int i = 0; i < doctors.length; i++) {
                people[pos] = (Person) doctors[i];
                pos = pos + 1;
            }
            return people;

        }



        // print all Info
    private void printAll(Person[] people, int count) {
        for (int i = 0; i < count; i++) {
            people[i].displayInfo();
            System.out.println();
        }
    }










    //sample data

    private void seedSampleData() {
        System.out.println("Seeding sample data...");
        Long pid = HelperUtils.generateId();
        Patient p = new Patient(pid, "intisar", "said", "O");
        p.addAllergy("AA");
        patientService.add(p);

    }


    public static void main(String[] args) {
        HospitalApp app = new HospitalApp();
        app.seedSampleData();  // put some example data in
        app.run();             // then show the menu
    }


    // ---------- the menu loop ----------

    private void run() {
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("===== School Management System =====");
            System.out.println("1. Patient");
            System.out.println("2. Doctor");
            System.out.println("3. Appointment");
            System.out.println("4. Reports");
            System.out.println("6. Exit");
            int choice = input.readInt("Choose an option", 1, 6);

            if (choice == 1) {
                patientMenu();
            }else if(choice == 4){
                reportMenu();
            }

            else if (choice == 6) {
                running = false;
                System.out.println("Goodbye!");
            }

        }
    }


}