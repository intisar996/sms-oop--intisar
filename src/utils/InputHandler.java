package utils;

import java.util.Scanner;

public class InputHandler {


    private Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public  Integer takeIntegerInput(){
        return scanner.nextInt();
    }

    public  Long takeLongInput(){

        return scanner.nextLong();
    }

    private boolean isWholeNumber(String line) {
        if (HelperUtils.isEmptyString(line)) {
            return false;
        }
        try {
            Integer.parseInt(line.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    // read any whole number
    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String line = scanner.nextLine();
            if (isWholeNumber(line)) {
                return Integer.parseInt(line.trim());
            }
            System.out.println("Please type a whole number.");
        }
    }



    // read a whole number within min..max, repeating until it is valid
    public int readInt(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt + " (" + min + "-" + max + ")");
            if (HelperUtils.inRange(value, min, max)) {
                return value;
            }
            System.out.println("Number must be between " + min + " and " + max + ".");
        }
    }



    // read text
    // read some non-empty text
    public String readText(String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String line = scanner.nextLine();
            if (HelperUtils.isValidText(line)) {
                return line.trim();
            }
            System.out.println("Please type something (it cannot be empty).");
        }
    }


}
