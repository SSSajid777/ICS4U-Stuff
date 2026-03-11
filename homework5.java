import java.util.Scanner;

public class homework5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your integer: ");
        int integer1=scan.nextInt();
        squareNumber(integer1);
        System.out.print("Enter your first number: ");
        int user_num1=scan.nextInt();
        System.out.print("Enter your second number: ");
        int user_num2=scan.nextInt();
        addNumbers(user_num1, user_num2);


    }
    public static void squareNumber(int integer){
        System.out.println("Given the integer "+ integer + ", the square of the integer is " + (int) Math.pow(integer, 2));
    }
    public static void addNumbers(int num1, int num2){
        System.out.println("The sum of the numbers is " + (num1+num2));

    }
}
