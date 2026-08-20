package main;

import entities.*;
import services.AppointmentService;
import services.DoctorService;
import services.NurseService;
import services.PatientService;
import utils.HelperUtils;
import utils.InputHandler;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

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


    // doctor
    private void  doctorMenu() {
        System.out.println("*****Doctor*****");
        System.out.println("1. Add   2. View all   3. Remove   4. Search  5-Search ById  6. add Surgeon  7-assignPatient  8-Available Doctors");
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
        }else if(choice ==2){
            Object[] d = doctorService.getAll();
            for (Object doctor : d) {
                System.out.println(doctor);
            }
            }else if(choice == 3){
                Long id = input.readLong("Enter ID");
                doctorService.removeById(id);
                System.out.println("Successfully remove Doctor");
            }else if(choice == 4){
            String keyword = input.readText("Search keyword");
            printEntities(doctorService.search(keyword));
        }
        else if(choice == 5){
            Long id = input.readLong("Enter ID");
            Doctor p = doctorService.searchById(id);
            System.out.println("Doctor ID: " + p.getId() + " FullName :  " + p.getFullName() + "  Age: " + p.getAge());
        } else if (choice == 6) {

            Long id = input.readLong("Enter ID");
            String firstName = input.readText("Enter First Name");
            String lastName = input.readText("Enter Last Name");
            Double consultationFee = input.readDouble("Enter Consultation Fee");
            Integer experienceYears = input.readInt("Enter Experience Years");
            Boolean isOnCall = input.readBoolean("Is On Call?");
            String specialization = input.readText("Enter Specialization");
            Boolean operationTheatreAccess = input.readBoolean("Operation Theatre Access?");

            Surgeon surgeon = new Surgeon(
                    id,
                    firstName,
                    lastName,
                    consultationFee,
                    experienceYears,
                    isOnCall,
                    specialization,
                    operationTheatreAccess
            );

            doctorService.addSurgeon(surgeon);
            System.out.println(
                    "Doctor ID: " + surgeon.getId() +
                            " FullName: " + surgeon.getFullName() +
                            " Age: " + surgeon.getAge()
            );
        } else if (choice == 7) {
            String spes = input.readText("Specialization");
            doctorService.listBySpecialization(spes);
        }else if (choice == 8) {
            doctorService.availableDoctors();
        }

        }

         // Nurse
         private void NurseMenu() {
             System.out.println("*****Nurse*****");
             System.out.println("1. Add   2. Remove ById  3. Search ById 4-Search  5. get All  6-listByShift  7-reassign");
             int choice = input.readInt("Choose", 1, 5);

             if (choice == 1) {
                 String first = input.readText("First name");
                 String last = input.readText("Last name");
                 String bloodGroup = input.readText("Blood Group");
                 Integer age = input.readInt("Enter age");
                 Integer ysersex = input.readInt("Enter Years Experience");
                 Long depId = input.readLong("Enter Department Id");
                 Nurse p = nurseService.addNurse(first, last,depId,ysersex,age);
                 System.out.println("Added Nurse with id " + p.getId());
             }else if(choice == 2){
                 Long id = input.readLong("Enter ID");
                 nurseService.removeById(id);
                 System.out.println("Successfully remove Nurse");
             }
             else if(choice == 3){
                 Long id = input.readLong("Enter ID");
                 Nurse p = nurseService.searchById(id);
                 System.out.println("Nurse ID: " + p.getId() + " FullName :  " + p.getFullName() + "  Age: " + p.getAge());
             }
             else if(choice == 4){
                 String keyword = input.readText("Search keyword");
                 printEntities(nurseService.search(keyword));
             } else if (choice == 5) {
                 Object[] p = nurseService.getAll();
                 for (Object nurse : p) {
                     System.out.println(nurse);
                 }
             }else if(choice == 6){
                 String shift = input.readText("Shift");
                 nurseService.listByShift(shift);
             }

         }



    //Appointment
    private void AppointmentMenu() {
        System.out.println("*****Appointment*****");
        System.out.println("1. Add   2. Remove ById  3. Search ById 4-Search  5. get All  6-listByShift  7-reassign");
        int choice = input.readInt("Choose", 1, 5);

        if (choice == 1) {
            Long patientId = input.readLong("patient Id : ");
            Long doctorId = input.readLong("doctorId: ");
            LocalDate localDate = LocalDate.parse(input.readText("date: "));
            LocalTime localTime  = LocalTime.parse(input.readText("Enter Time"));


            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            Time time = Time.valueOf(localTime);

            Appointment p = appointmentService.schedule(patientId, doctorId,date,time);
            System.out.println("Added Appoitment with id " + p.getAppointmentId());
        }else if(choice == 2){
            Long id = input.readLong("Enter ID");
            nurseService.removeById(id);
            System.out.println("Successfully remove Nurse");
        }
        else if(choice == 3){
            Long id = input.readLong("Enter ID");
            Nurse p = nurseService.searchById(id);
            System.out.println("Nurse ID: " + p.getId() + " FullName :  " + p.getFullName() + "  Age: " + p.getAge());
        }
        else if(choice == 4){
            String keyword = input.readText("Search keyword");
            printEntities(nurseService.search(keyword));
        } else if (choice == 5) {
            Object[] p = nurseService.getAll();
            for (Object nurse : p) {
                System.out.println(nurse);
            }
        }else if(choice == 6){
            String shift = input.readText("Shift");
            nurseService.listByShift(shift);
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