/*
Name: Sajid Abdullah
Date: March 26, 2026
Description: This is a Hi-Lo guessing game program with a main menu and sub menu.
The user picks a difficulty (Easy, Medium, Hard, or Custom) and tries to guess a random number.
Easy has 100 guesses (1-20), Medium has 10 guesses (1-100), Hard has 3 guesses (1-100),
Custom lets the user pick their own number range and number of guesses.
The program tracks and displays all guesses using an ArrayList.

Resources:
https://www.asciiart.eu/text-to-ascii-art#google_vignette (ASCII art for titles)
https://www.w3schools.com/java/java_arraylist.asp (I used this for the arraylist equivalent of .length and [i], which is .size() and .get(i))
*/

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Assignment2 {

    public static int validInput; // global variable for error handling
    public static Random rand = new Random(); // global random for hiLo method

    // colour codes global so hiLo method can use them
    public static String RESET  = "\u001B[0m";
    public static String RED    = "\u001B[31m";
    public static String GREEN  = "\u001B[32m";
    public static String YELLOW = "\u001B[33m";
    public static String BLUE   = "\u001B[34m";
    public static String PURPLE = "\u001B[35m";
    public static String CYAN   = "\u001B[36m";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int choice1, choice2;
        boolean decision1, decision2, decision3;
        decision1 = true;

        // show loading screen when program starts
        loading();
        timer2(); // wait for load sound to finish
        System.out.print("Press enter to continue: ");
        scan.nextLine();

        // main menu loop
        while (decision1) {
            while (true) {
                System.out.print("\033[H\033[2J"); // clears the screen

                // main menu ASCII art typed out with ghostwriterArt
                String mainArt = (PURPLE + """
                        .-..-.        _
                        : `' :       :_;
                        : .. : .--.  .-.,-.,-.
                        : :; :' .; ; : :: ,. :
                        :_;:_;`.__,_;:_;:_;:_;

                        .-..-.
                        : `' :
                        : .. : .--. ,-.,-..-..-.
                        : :; :' '_.': ,. :: :; :
                        :_;:_;`.__.':_;:_;`.__.'
                        """ + RESET);
                ghostwriterArt(mainArt);

                // menu options in blue
                System.out.println(BLUE + "        1.) Hi-Lo Guessing Game" + RESET);
                System.out.println(BLUE + "        2.) Exit Program" + RESET);
                System.out.println("");

                System.out.print(YELLOW + "Enter a choice: " + RESET);
                String test = scan.next();
                errorCheck(test, 1, 2, "Enter a choice: "); // call to method
                choice1 = validInput;

                // if you choose the game
                if (choice1 == 1) {
                    break;
                } // if you exit the program
                else if (choice1 == 2) {
                    System.out.print("\033[H\033[2J"); // clears the screen
                    System.out.print(CYAN);
                    ghostwriter("Thank you for using my program!");
                    System.out.print(RESET);
                    decision1 = false;
                    break;
                }
            }

            // goes to the Hi-Lo sub menu
            if (choice1 == 1) {
                decision2 = true;
                while (decision2) {
                    while (true) {
                        System.out.print("\033[H\033[2J"); // clears the screen

                        // sub menu ASCII art typed out with ghostwriterArt
                        String subArt = (PURPLE + """
.-..-. _            .-.                                                    
: :; ::_;           : :                                                    
:    :.-.   _____   : :    .--.                                            
: :: :: :  :_____:  : :__ ' .; :                                           
:_;:_;:_;           :___.'`.__.'                                           
                                                                           
 .--.                          _                .--.                       
: .--'                        :_;              : .--'                      
: : _ .-..-. .--.  .--.  .--. .-.,-.,-. .--.   : : _  .--.  ,-.,-.,-. .--. 
: :; :: :; :' '_.'`._-.'`._-.': :: ,. :' .; :  : :; :' .; ; : ,. ,. :' '_.'
`.__.'`.__.'`.__.'`.__.'`.__.':_;:_;:_;`._. ;  `.__.'`.__,_;:_;:_;:_;`.__.'
                                        .-. :                              
                                        `._.'                              
                                """ + RESET);
                        ghostwriterArt(subArt);

                        // menu options in blue
                        System.out.println(BLUE + "        1.) Easy   (1 - 20,   100 guesses)" + RESET);
                        System.out.println(BLUE + "        2.) Medium (1 - 100,  10 guesses)" + RESET);
                        System.out.println(BLUE + "        3.) Hard   (1 - 100,  3 guesses)" + RESET);
                        System.out.println(BLUE + "        4.) Custom (you choose range and guesses)" + RESET);
                        System.out.println(BLUE + "        5.) Return to Main Menu" + RESET);
                        System.out.println("");

                        System.out.print(YELLOW + "Enter a choice: " + RESET);
                        String test = scan.next();
                        errorCheck(test, 1, 5, "Enter a choice: "); // call to method
                        choice2 = validInput;

                        // if you choose easy, medium, hard, or custom
                        if (choice2 == 1 || choice2 == 2 || choice2 == 3 || choice2 == 4) {
                            break;
                        } // if you return to main menu
                        else if (choice2 == 5) {
                            System.out.print("\033[H\033[2J"); // clears the screen
                            System.out.print(CYAN);
                            ghostwriter("Returning to main menu");
                            System.out.print(RESET);
                            decision2 = false;
                            break;
                        }
                    }

                    // if user picked return to main menu
                    if (decision2 == false) {
                        decision3 = false;
                    } else {
                        decision3 = true;
                    }

                    // game loop
                    while (decision3) {
                        System.out.print("\033[H\033[2J"); // clears the screen

                        int maxNumber, maxGuesses, minNumber;
                        String difficultyName;

                        // set difficulty settings
                        if (choice2 == 1) {
                            minNumber = 1;
                            maxNumber = 20;
                            maxGuesses = 100;
                            difficultyName = "Easy";
                        } else if (choice2 == 2) {
                            minNumber = 1;
                            maxNumber = 100;
                            maxGuesses = 10;
                            difficultyName = "Medium";
                        } else if (choice2 == 3) {
                            minNumber = 1;
                            maxNumber = 100;
                            maxGuesses = 3;
                            difficultyName = "Hard";
                        } else {
                            // custom mode - ask user for their settings
                            System.out.print(YELLOW + "Enter minimum number: " + RESET);
                            String t1 = scan.next();
                            errorCheck(t1, 1, 9999, "Enter minimum number: ");
                            minNumber = validInput;

                            System.out.print(YELLOW + "Enter maximum number: " + RESET);
                            String t2 = scan.next();
                            errorCheck(t2, minNumber + 1, 9999, "Enter maximum number: ");
                            maxNumber = validInput;

                            System.out.print(YELLOW + "Enter number of guesses: " + RESET);
                            String t3 = scan.next();
                            errorCheck(t3, 1, 9999, "Enter number of guesses: ");
                            maxGuesses = validInput;

                            difficultyName = "Custom";
                        }

                        // call the hiLo function with difficulty settings
                        hiLo(minNumber, maxNumber, maxGuesses, difficultyName);

                        // ask user to play again or go back to sub menu
                        while (true) {
                            System.out.println(YELLOW + "Would you like to play again, y or n?" + RESET);
                            String playAgain = scan.next().toLowerCase();
                            if (playAgain.equals("y")) {
                                break; // loops back to play again
                            } else if (playAgain.equals("n")) {
                                decision3 = false; // exits game loop, goes back to sub menu
                                break;
                            } else {
                                System.out.print("\033[H\033[2J"); // clears the screen
                                System.out.print(RED);
                                ghostwriter("Only input y or n!");
                                System.out.print(RESET);
                            }
                        }
                    }
                }
            }
        }
    }

    // function for high low guessing game taking in a variable
    // for the game range and the number of guesses
    public static void hiLo(int min1, int max1, int counter1, String difficultyName) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> guesses = new ArrayList<>(); // arraylist to store guesses
        int answer = rand.nextInt(max1 - min1 + 1) + min1; // random number to guess

        // show difficulty info in purple
        System.out.print(PURPLE);
        ghostwriter("Difficulty: " + difficultyName);
        System.out.print(RESET);
        System.out.println("Enter a value between " + min1 + " and " + max1);
        System.out.println(YELLOW + "You have " + counter1 + " guesses remaining" + RESET);
        System.out.println("");
        delay(); // 3s delay

        // guessing loop
        while (counter1 > 0) {
            System.out.print(YELLOW + "Input a guess: " + RESET);
            String test = scan.next();
            errorCheck(test, min1, max1, "Input a guess: "); // call to method
            int temp = validInput;

            guesses.add(temp); // add guess to arraylist

            System.out.print("\033[H\033[2J"); // clears the screen after each guess

            // check if guess is correct, higher, or lower
            if (temp == answer) {
                playSoundBackground("win.wav"); // start sound first
                System.out.print(GREEN);
                ghostwriter("You got it!");
                System.out.print(RESET);

                System.out.print(CYAN + "Your guesses: " + RESET);
                for (int i = 0; i < guesses.size(); i++) {
                    if (i == guesses.size() - 1) {
                        System.out.println(guesses.get(i)); // last guess, no comma
                    } else {
                        System.out.print(guesses.get(i) + ", "); // comma between guesses
                    }
                }
                System.out.println("");
                break;
            } else if (temp > answer) {
                playSoundBackground("incorrect_sound.wav"); // start sound first
                System.out.print(RED);
                ghostwriter("Too high, guess lower!");
                System.out.print(RESET);
                counter1 -= 1;
            } else if (temp < answer) {
                playSoundBackground("incorrect_sound.wav"); // start sound first
                System.out.print(BLUE);
                ghostwriter("Too low, guess higher!");
                System.out.print(RESET);
                counter1 -= 1;
            }

            // show remaining guesses in yellow and current guesses in cyan
            System.out.println(YELLOW + "You have " + counter1 + " guesses remaining" + RESET);
            System.out.print(CYAN + "Your current guesses: " + RESET);
            for (int i = 0; i < guesses.size(); i++) {
                if (i == guesses.size() - 1) {
                    System.out.println(guesses.get(i)); // last guess, no comma
                } else {
                    System.out.print(guesses.get(i) + ", "); // comma between guesses
                }
            }
            System.out.println("");
        }

        // if player ran out of guesses
        if (counter1 == 0) {
            playSoundBackground("lose.wav"); // start sound first
            System.out.print(RED);
            ghostwriter("You ran out of guesses! The answer was " + answer);
            System.out.print(RESET);

            System.out.print(CYAN + "Your guesses: " + RESET);
            for (int i = 0; i < guesses.size(); i++) {
                if (i == guesses.size() - 1) {
                    System.out.println(guesses.get(i)); // last guess, no comma
                } else {
                    System.out.print(guesses.get(i) + ", "); // comma between guesses
                }
            }
            System.out.println("");
        }

        delay(); // 3s delay
    }

    // ghostwriter for ASCII art - types out fast without deleting
    public static void ghostwriterArt(String sentence){
        for (int i = 0; i < sentence.length(); i++){
            System.out.print(sentence.charAt(i) + "");
            timerArt(); // fast delay for ASCII art
        }
        System.out.println(); // goes to next line
    }

    // ghostwriter for messages - types out, waits, then deletes
    public static void ghostwriter(String sentence){
        for (int i = 0; i < sentence.length(); i++){
            System.out.print(sentence.charAt(i) + "");
            timerMsg(); // medium delay while typing
        }
        timer2(); // wait so user can read it
        //deletes 1 letter at a time using \b for backspace
        for (int j = sentence.length() - 1; j > -1; j--){
            System.out.print("\b \b");
            timerMsg(); // medium delay while deleting
        }
    }

    //this function prints the loading screen animation
    public static void loading(){
        playSoundBackground("load.wav"); // play loading sound at same time as animation
        String dots = "....";
        for (int i = 0; i < 4; i++){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.print("Loading" + "");
            for (int j = 0; j < dots.length(); j++){
                System.out.print(dots.charAt(j));
                timer1(); // normal speed for loading dots
            }
        System.out.println();//goes to the next line
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
                    System.out.println(RED + "Enter between " + min1 + " and " + max1 + RESET);
                    timer2();
                    System.out.print("\033[H\033[2J");
                    System.out.print(YELLOW + prompt + RESET);
                    word = scan.next();
                }
                // breaks if between the max and min values
                else {
                    break;
                }
            }
            // goes here if an integer is not input
            catch (Exception e) {
                System.out.println(RED + "Enter an integer only!" + RESET);
                timer2();
                System.out.print("\033[H\033[2J");
                System.out.print(YELLOW + prompt + RESET);
                word = scan.next();
            }
        }
    }

    // method to delay by 3 seconds
    public static void delay(){
        try {
            Thread.sleep(3000); // 3000ms = 3 seconds
        } catch (Exception e) {
        }
        System.out.flush();
    }

    // function for timer at 100ms for loading dots
    public static void timer1(){
        try{
            Thread.sleep(100); // 100ms
        } catch (Exception e) {}
    }

    // function for timer at 2 seconds
    public static void timer2(){
        try{
            Thread.sleep(2000); // 2000ms
        } catch (Exception e) {}
    }

    // function for timer at 5ms for fast ASCII art
    public static void timerArt(){
        try{
            Thread.sleep(5); // 5ms
        } catch (Exception e) {}
    }

    // function for timer at 50ms for messages
    public static void timerMsg(){
        try{
            Thread.sleep(50); // 50ms
        } catch (Exception e) {}
    }

    // method to play a sound file without waiting so other things run at same time
    public static void playSoundBackground(String filename){
        File lol = new File(filename);
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(lol));
            clip.start(); // starts sound and moves on immediately
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}