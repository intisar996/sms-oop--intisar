package utils;


import java.util.Date;

public class HelperUtils {








    public static  boolean  isValidId(Long id){
        return  id != null && id > 0;
    }


    public static  boolean isValidEmail(String email){
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static boolean isEmptyString(String text){
        return text == null || text.trim().isEmpty();
    }

    public static boolean isValidDate(Date date){
        return date != null && date.after(new Date());
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





















}
