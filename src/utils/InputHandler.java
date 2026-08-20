package utils;

import java.util.Scanner;

public class InputHandler {

    public static Integer takeIntegerInput(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static Long takeLongInput(){
        Scanner input = new Scanner(System.in);
        return input.nextLong();
    }


}
