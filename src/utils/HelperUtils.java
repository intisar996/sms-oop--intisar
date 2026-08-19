package utils;


public class HelperUtils {





    public static  boolean  isValidId(long id){
        return  id <= 0;
    }


    public static  boolean isValidEmail(String email){
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static boolean isEmptyString(String text){
        return text == null || text.trim().isEmpty();
    }


    public  static  boolean isValidAmount(Double amount ){
        return  amount == null|| amount < 0;
    }





}
