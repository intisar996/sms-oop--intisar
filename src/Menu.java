public class Menu {

    public static void displayMenu() {
        String menuString = """
                1- Patient Menu
                2- Student Menu
                3- Teacher Menu
                4- Exit
                """;
        IO.println(menuString);
    }




    public static void displayPatientMenu(){
        String PatientMenuString = """
                1- Add new Patient
                2- Display All
                3- Add New School
                4- Update School By Id
                5- Delete School By Id
                6- Delete School by Name
                7- Delete All School
                8- Go Back to Main Menu
                """;

        IO.println(PatientMenuString);
    }



}
