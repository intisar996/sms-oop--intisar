import entities.Patient;
import services.PatientService;
import utils.HelperUtils;

import java.util.ArrayList;
import java.util.List;

public class HospitalApp {

    static List<Patient> studentList = new ArrayList<>();

    static void main() {
        runProgram();
    }


    static void runProgram(){
        Boolean exitFlag = false;
        PatientService patientService = new PatientService();

        while (exitFlag.equals(false)){
            Menu.displayMenu();
            Integer option = HelperUtils.takeIntegerInput();

            if(option.equals(1)){
                Menu.displayPatientMenu();
                IO.println("Enter Patient Option: ");
                Integer patientOption =  HelperUtils.takeIntegerInput();
                 patientService.menuReslover(patientOption);
            }

            if (option.equals(4)) {
                exitFlag = Boolean.TRUE;
            }


        }
    }




}
