import java.util.Random;
import java.util.Scanner;

public class HiLoFunction {

    public static int validInput; // global variable for error handling

    public static void main(String[] args) {
        // test the function with easy settings
        hiLo(1, 20, 100);
    }

    // hi lo guessing game function that takes min, max, and number of guesses
    public static void hiLo(int min, int max, int counter) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        int secretNumber = rand.nextInt(min, max + 1); // random number to guess
        int guessCount = 0;
        int[] guesses = new int[counter]; // array to store guesses
        boolean won = false;

        System.out.println("Guess a number between " + min + " and " + max);
        System.out.println("You have " + counter + " guesses!");
        System.out.println("");

        // guessing loop
        while (guessCount < counter) {
            System.out.print("Enter your guess: ");
            String test = scan.next();
            errorCheck(test, min, max, "Enter your guess: "); // call to method
            int guess = validInput;

            guesses[guessCount] = guess; // store guess in array
            guessCount++;

            // check if guess is correct, higher, or lower
            if (guess == secretNumber) {
                System.out.println("Correct!");
                won = true;
                break;
            } else if (guess < secretNumber) {
                System.out.println("Higher!");
            } else {
                System.out.println("Lower!");
            }

            // show all guesses so far
            System.out.print("Your guesses so far: ");
            for (int i = 0; i < guessCount; i++) {
                if (i == guessCount - 1) {
                    System.out.println(guesses[i]); // last guess, no comma
                } else {
                    System.out.print(guesses[i] + ", "); // comma between guesses
                }
            }

            System.out.println("Guesses remaining: " + (counter - guessCount));
            System.out.println("");
        }

        // if player ran out of guesses
        if (!won) {
            System.out.println("Out of guesses! The answer was " + secretNumber);
        }

        // show final list of all guesses
        System.out.print("Your guesses: ");
        for (int i = 0; i < guessCount; i++) {
            if (i == guessCount - 1) {
                System.out.println(guesses[i]); // last guess, no comma
            } else {
                System.out.print(guesses[i] + ", "); // comma between guesses
            }
        }
    }

    //error handling method that takes in 4 parameters
    public static void errorCheck(String word, int min1, int max1, String prompt){
        Scanner scan = new Scanner(System.in);
        while (true){
            try {
                // tries to convert the string to an integer
                validInput = Integer.parseInt(word);
                // prints if outside the max and min values
                if (validInput < min1 || validInput > max1){
                    System.out.println("Enter between " + min1 + " and " + max1);
                    System.out.print(prompt);
                    word = scan.next();
                }
                // breaks if between the max and min values
                else {
                    break;
                }
            }
            // goes here if an integer is not input
            catch (Exception e) {
                System.out.println("Enter an integer only!");
                System.out.print(prompt);
                word = scan.next();
            }
        }
    }
}
