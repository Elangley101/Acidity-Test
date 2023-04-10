import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); //text scanner

        System.out.print("Enter first name: ");
        String firstName = in.nextLine();
        System.out.print("Enter last name: ");
        String lastName = in.nextLine();
        System.out.print("Enter email: ");
        String email = in.nextLine();
        Employee employee = new Employee(firstName, lastName, email);
        Survey survey = new Survey(employee);
        //infinite loop
        while (true) {
            System.out.print("Enter file name: ");
            try {
                String fileName = in.nextLine();
                survey.readFromFile(fileName); //read data from file
                break; //if no Exception exit from loop
            } catch (FileNotFoundException e) {
                System.out.println("File not exist. Try again.");

            }
        }
        int rate = survey.rateMySample(survey.getParameters());//Calculates the number of parameters out of range
        survey.badgeAssignment(rate);//Sets the quality badge depending on the number of parameters out of range
        System.out.println(survey.toString());
    }
}
