import java.util.Scanner;

public class decision {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a grade");
        int grade = scan.nextInt();

        if (grade >= 80 && grade <= 100) {
            System.out.println("Grade A");

        } else if (grade >= 80 && grade <= 100) {
            System.out.println("Grade A");

        } else if (grade >= 70 && grade < 80) {
            System.out.println("Grade B");

        } else if (grade >= 60 && grade < 70) {
            System.out.println("Grade C");

        } else if (grade >= 50 && grade < 60) {
            System.out.println("Grade D");

        } else if (grade >= 0 && grade < 50) {
            System.out.println("Grade F");
        } else if (grade < 0 || grade > 100) {
            System.out.println("Invalid Grade");

        }

    }
}