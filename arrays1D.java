import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


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
        int rannum = rand.nextInt(0, 3);
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


        
        //sample program 1 using a 1D arrays
        String[] questions1 = { "2 + 3 =", "4 - 7 =", "12 * 3 =" };
        int[] answers1 = { 2 + 3, 4 - 7, 12 * 3 };
        int rannum1 = rand.nextInt(0, 2);
        System.out.println(questions1[rannum]);
        int x1 = scan.nextInt();
        if (x1 == answers1[rannum1]) {
            System.out.println("You got it right!");
        } else {
            System.out.println("You got it wrong!");
        }


        //sample program 2 using a HashMap (key:value)
        HashMap<String, Integer> questAns = new HashMap<>();
        questAns.put("2 + 3 =", 5);
        questAns.put("4 - 7 =", -3);
        questAns.put("12 * 3 =", 36);
        ArrayList<String> questions2 = new ArrayList<>(questAns.keySet());
        // Pick a random question from the hashmap
        String randomQuestion = questions2.get(rand.nextInt(questions2.size()));
        System.out.println(randomQuestion);
        int userAnswer = scan.nextInt();
        if (userAnswer == questAns.get(randomQuestion)) {
            System.out.println("You got it right");
        } else {
            System.out.println("You got it wrong");
        }

        scan.close();
    }
}
