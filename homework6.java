import java.util.Scanner;

public class homework6 {

    public static String validInput; // global variable

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String correctUsername = "admin";
        String correctPassword = "python123";
        int attempts = 0;

        while (attempts < 3) {
            System.out.print("Enter username: ");
            String test = scan.nextLine();
            errorCheck(test); 
            String username = validInput;

            System.out.print("Enter password: ");
            test = scan.nextLine();
            errorCheck(test);
            String password = validInput;

            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("Login successfull! Welcome, " + username + "!");
                break;
            } else {
                System.out.println("Incorrect username or password!");
                attempts++;
            }

            
            if (attempts == 3) {
                System.out.println("Account Locked");
            }
        }
    }

    public static void errorCheck(String x) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            
            if (x.isEmpty()) {
                System.out.println("Input cannot be empty!");
                System.out.print("Try again: ");
                x = scan.next();
            } else {
                try {
                    Double.parseDouble(x);
                    System.out.println("Error: You inputted number. Only input texts!");
                    System.out.print("Try again: ");
                    x = scan.next();
                } catch (Exception e) {
                    validInput = x;
                    break;
                }
            }
        }
    }
}