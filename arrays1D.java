import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;


public class arrays1D {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        // the list nums starts at index 0 to index 2
        // initializes a list with 3 items that are the same
        int[] nums1 = { 4, 6, 10 };
        System.out.println(nums1[0]);// outputs 4 from the list nums


        // sample program that shows how to create random questions with answers
        String[] questions = { "2 + 3 =", "4 - 7 =", "12 * 3 =" };
        int[] answers = { 2 + 3, 4 - 7, 12 * 3 };
        int rannum = rand.nextInt(0, 2);
        System.out.println(questions[rannum]);
        int x = scan.nextInt();
        if (x == answers[rannum]) {
            System.out.println("You got it right");
        } else {
            System.out.println("You got it wrong");
        }


        System.out.println(); //space between


        // creates an empty arraylist called numbers
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.println("Input a number ");
            // this variable is being used as a temporary variable for input
            int temp = scan.nextInt();
            // this adds the temp value to the arraylist
            numbers.add(temp);
        }
        // sorts the list of numbers
        Collections.sort(numbers);
        // prints the sorted list
        System.out.println("least to greatest");
        for (int i = 0; i < 5; i++) {
            System.out.print(numbers.get(i) + " ");
        }
        // prints the sorted list
        System.out.println("\ngreatest to least");
        for (int j = 5 - 1; j >= 0; j--) {
            System.out.print(numbers.get(j) + " ");
        }
        System.out.println(); //space between
        double sum = 0;
        System.out.println("How many numbers do you want the avg of?");
        int howmany = scan.nextInt();
        ArrayList<Double> numbers1 = new ArrayList<>();
        for (int i = 0; i < howmany; i++) {
            System.out.println("Input a number ");
            // this variable is being used as a temporary variable for input
            double temp = scan.nextDouble();
            // this adds the temp value to the arraylist
            numbers1.add(temp);
            sum = sum + numbers1.get(i);
        }
        System.out.println("The average of the numbers " + sum/howmany);
        for (int i = 0; i < howmany; i++){
            System.out.print(numbers1.get(i) + " ");
        }
        scan.close();
    }
}
