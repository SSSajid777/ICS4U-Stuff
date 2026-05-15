import java.util.Scanner;
import java.io.*;
import static java.lang.System.*;

public class userInput {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // defines variables
        String firstName, lastName, address;
        long phoneNumber;

        // asks user to input their information
        out.println("Please enter your first name:");
        firstName = scan.nextLine();

        out.println("Please enter your last name:");
        lastName = scan.nextLine();

        out.println("Please enter your address:");
        address = scan.nextLine();

        out.println("Please enter your phone number:");
        phoneNumber = scan.nextLong();

        // converts the phone number to an int
        int p = (int)(phoneNumber);

        try {
            // writes the user's information to userInput.txt
            FileWriter fw = new FileWriter("userInput.txt");
            PrintWriter pw = new PrintWriter(fw);

            pw.println("First Name: " + firstName);
            pw.println("Last Name: " + lastName);
            pw.println("Address: " + address);
            pw.println("Phone Number: " + p);

            pw.close();
            out.println("Information saved to userInput.txt");
        } catch (IOException e) {
            out.println("Error writing file!");
        }
    }
}