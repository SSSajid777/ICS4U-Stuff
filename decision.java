import java.util.Scanner;

public class decision {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a grade");
        int grade = scan.nextInt();

        if (grade >= 50 && grade <= 100) {
            System.out.println("You pass");

        }
        else{
            System.out.println("You failed");
        }
        

    }
}