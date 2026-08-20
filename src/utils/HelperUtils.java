package utils;


import entities.Patient;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HelperUtils {








    public static  boolean  isValidId(Long id){
        return  id != null && id > 0;
    }


    public static  boolean  isValidNationalId(String id){
        return id != null && id.matches("\\d{7}");
    }

    public static boolean isValidPhone(String id) {
        return id != null && id.matches("\\d{8}");
    }


    public static  boolean isValidEmail(String email){
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static boolean isEmptyString(String text){
        return text == null || text.trim().isEmpty();
    }

    public static boolean isValidBirth(Date date){
        return date != null && !date.after(new Date());
    }

    public static boolean isValidDate(Date date){
        return date != null && !date.before(new Date());
    }

    public static boolean isValidVisitDate(Date date) {
        return date != null && !date.after(new Date());
    }





    public  static  boolean isValidAmount(Double amount ){
        return  amount != null && amount >= 0;
    }


    public static boolean isValidNumber(Integer number) {
        return number != null && number >= 0;
    }


    public static boolean isValidAge(Integer age) {
        return age != null && age >= 0 && age <= 120;
    }

    public static boolean  isPatientListEmpty(List<Patient> patientList) {
        return patientList == null || patientList.isEmpty();
    }

























}
