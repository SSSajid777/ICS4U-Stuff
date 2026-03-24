import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class homework7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();



        double sum = 0;
        System.out.println("Enter 10 numbers to get the sum and average");
        int howmany = 10;
        ArrayList<Double> numbers1 = new ArrayList<>();
        for (int i = 0; i < howmany; i++) {
            System.out.println("Input a number ");
            // this variable is being used as a temporary variable for input
            double temp = scan.nextDouble();
            // this adds the temp value to the arraylist
            numbers1.add(temp);
            sum = sum + numbers1.get(i);
        }
        System.out.println("The sum of the numbers " + sum);
        System.out.println("The average of the numbers " + sum/howmany);
        

        
    }
}
