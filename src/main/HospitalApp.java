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
        System.out.println("1. Add   2. Remove ById  3. Search ById 4-Search  5. Update contact  6-View All  7-listInPatients 8-totalOutstanding");
        int choice = input.readInt("Choose", 1, 5);

        if (choice == 1) {
            String first = input.readText("First name");
            String last = input.readText("Last name");
            String bloodGroup = input.readText("Blood Group");
            Integer age = input.readInt("Enter age");
            Patient p = patientService.addPatient(first, last, bloodGroup,age);
            System.out.println("Added patient with id " + p.getId());
        }else if(choice == 2){
            Long id = input.readLong("Enter ID");
            patientService.removeById(id);
            System.out.println("Successfully remove Patient");
        }
        else if(choice == 3){
            Long id = input.readLong("Enter ID");
            Patient p = patientService.searchById(id);
            System.out.println("patient ID: " + p.getId() + " FullName :  " + p.getFullName() + "  Age: " + p.getAge());
        }
        else if(choice == 4){
            String keyword = input.readText("Search keyword");
            printEntities(patientService.search(keyword));
        } else if (choice == 5) {
            Long id = input.readLong("Patient id");
            String phone = input.readText("New phone");
            String email = input.readText("New email");
            patientService.updateContact(id, phone, email);
        }else if(choice == 6){

            Object[] p = patientService.getAll();
            for (Object patient : p) {
                System.out.println(patient);
            }
        }else if(choice == 7){

            Object[] p = patientService.listInPatients();
            for (Object patient : p) {
                InPatient inPatient = (InPatient) patient;
                inPatient.displayInfo();
            }
        }else if(choice == 8){
            double total = patientService.totalOutstanding();

            System.out.println("Total Outstanding Balance: " + total);
        }



    }



    private void  doctorMenu() {
        System.out.println("*****Doctor*****");
        System.out.println("1. Add   2. View all   3. Search   4. Update contact   5. Remove ");
        int choice = input.readInt("Choose", 1, 5);
        Long doid = HelperUtils.generateId();
        if (choice == 1) {
            String first = input.readText("First name");
            String last = input.readText("Last name");
            Integer age = input.readInt("Enter age");
            Double fee = input.readDouble("Enter consultation Fee");
            Integer exp = input.readInt("Enter experience Years");
            String specialization = input.readText("Enter specialization");

            Doctor doctor = new Doctor(doid,first,last,age,fee, true,specialization);
            doctorService.add(doctor);
            System.out.println("Added student with id " + doctor.getId());
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


         // find Oldest by age
         System.out.println("Oldest person");
         Person oldest = findOldest(people,count);
         if (oldest != null) {
             oldest.displaySummary();
             System.out.println("Age: " + oldest.getAge());
         }



     }



    private Person findOldest(Person[] people, int count){
        if(count == 0) {
            return null;
        }
        Person oldest = people[0];

        for (int i = 1; i < count; i++) {
            if(people[i].getAge() > oldest.getAge()){
                oldest = people[i];
            }

        }
        return oldest;
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
        Patient p = new Patient(pid, "intisar", "said", "O",30);
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
            System.out.println("3. Nurse");
            System.out.println("4. Reports");
            System.out.println("6. Exit");
            int choice = input.readInt("Choose an option", 1, 6);

            if (choice == 1) {
                patientMenu();
            }else if(choice == 2) {
                doctorMenu();
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