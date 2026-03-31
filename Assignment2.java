/*
Name: Sajid Abdullah
Date: March 26, 2026
Description: This is a Hi-Lo guessing game program with a main menu and sub menu.
The user picks a difficulty (Easy, Medium, Hard, or Custom) and tries to guess a random number.
Easy has unlimited guesses (1-20), Medium has 10 guesses (1-100), Hard has 3 guesses (1-100),
Custom lets the user pick their own number range and number of guesses.
The program tracks and displays all guesses at the end using array.

Resources:
https://www.asciiart.eu/text-to-ascii-art#google_vignette (ASCII art for titles)
*/

import java.io.File;
import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Assignment2 {

    public static int validInput; // global variable for error handling

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        String RESET  = "\u001B[0m";
        String RED    = "\u001B[31m";
        String GREEN  = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String BLUE   = "\u001B[34m";
        String PURPLE = "\u001B[35m";

        int choice1, choice2;
        boolean decision1, decision2, decision3;
        decision1 = true;

        // show loading screen when program starts
        loading();
        System.out.print("Press enter to continue: ");
        scan.nextLine();

        // main menu loop
        while (decision1) {
            while (true) {
                System.out.print("\033[H\033[2J"); // clears the screen

                // main menu ASCII art
                System.out.println(PURPLE + """
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

                // menu options stay on screen so user can read and pick
                System.out.println(BLUE + "        1.) Hi-Lo Guessing Game" + RESET);
                System.out.println(BLUE + "        2.) Exit Program" + RESET);
                System.out.println("");

                System.out.print("Enter a choice: ");
                String test = scan.next();
                errorCheck(test, 1, 2, "Enter a choice: "); // call to method
                choice1 = validInput;

                // if you choose the game
                if (choice1 == 1) {
                    break;
                } // if you exit the program
                else if (choice1 == 2) {
                    System.out.print("\033[H\033[2J"); // clears the screen
                    ghostwriter("Thank you for using my program!"); // types then deletes
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

                        // sub menu ASCII art
                        System.out.println(PURPLE + """
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

                        // menu options stay on screen so user can read and pick
                        System.out.println(BLUE + "        1.) Easy   (1 - 20,   unlimited guesses)" + RESET);
                        System.out.println(BLUE + "        2.) Medium (1 - 100,  10 guesses)" + RESET);
                        System.out.println(BLUE + "        3.) Hard   (1 - 100,  3 guesses)" + RESET);
                        System.out.println(BLUE + "        4.) Custom (you choose range and guesses)" + RESET);
                        System.out.println(BLUE + "        5.) Return to Main Menu" + RESET);
                        System.out.println("");

                        System.out.print("Enter a choice: ");
                        String test = scan.next();
                        errorCheck(test, 1, 5, "Enter a choice: "); // call to method
                        choice2 = validInput;

                        // if you choose easy, medium, hard, or custom
                        if (choice2 == 1 || choice2 == 2 || choice2 == 3 || choice2 == 4) {
                            break;
                        } // if you return to main menu
                        else if (choice2 == 5) {
                            System.out.print("\033[H\033[2J"); // clears the screen
                            ghostwriter("Returning to main menu"); // types then deletes
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
                            maxGuesses = 100; // effectively unlimited
                            difficultyName = "Easy";
                        } else if (choice2 == 2) {
                            minNumber = 1;
                            maxNumber = 100;
                            maxGuesses = 10;
                            difficultyName = "Medium";
                        } else {
                            // placeholder for hard and custom coming soon
                            minNumber = 1;
                            maxNumber = 20;
                            maxGuesses = 100;
                            difficultyName = "Easy";
                        }

                        int secretNumber = rand.nextInt(minNumber, maxNumber + 1); // random number to guess
                        int guessCount = 0;
                        int[] guesses = new int[maxGuesses]; // array to store guesses
                        boolean won = false;

                        // show difficulty info, stays on screen
                        System.out.println(PURPLE + "Difficulty: " + difficultyName + RESET);
                        System.out.println("Guess a number between " + minNumber + " and " + maxNumber);
                        if (choice2 == 1) {
                            System.out.println("You have unlimited guesses!");
                        } else {
                            System.out.println("You have " + maxGuesses + " guesses!");
                        }
                        System.out.println("");
                        delay(); // 3s delay

                        // guessing loop
                        while (guessCount < maxGuesses) {
                            System.out.print(YELLOW + "Enter your guess: " + RESET);
                            String test = scan.next();
                            errorCheck(test, minNumber, maxNumber, "Enter your guess: "); // call to method
                            int guess = validInput;

                            guesses[guessCount] = guess; // store guess in array
                            guessCount++;

                            // check if guess is correct, higher, or lower
                            if (guess == secretNumber) {
                                ghostwriter(GREEN + "Correct!" + RESET); // types then deletes
                                playSound("correct_sound.wav"); // play correct sound
                                won = true;
                                break;
                            } else if (guess < secretNumber) {
                                ghostwriter(BLUE + "Higher!" + RESET); // types then deletes
                            } else {
                                ghostwriter(RED + "Lower!" + RESET); // types then deletes
                            }

                            // show remaining guesses for medium mode
                            if (choice2 == 2) {
                                System.out.println(YELLOW + "Guesses remaining: " + (maxGuesses - guessCount) + RESET);
                            }
                        }

                        // if player ran out of guesses
                        if (!won) {
                            ghostwriter(RED + "Out of guesses! The answer was " + secretNumber + RESET);
                            playSound("incorrect_sound.wav"); // play incorrect sound
                        }

                        // display all guesses from array, stays on screen
                        System.out.print("Your guesses: ");
                        for (int i = 0; i < guessCount; i++) {
                            if (i == guessCount - 1) {
                                System.out.println(guesses[i]); // last guess, no comma
                            } else {
                                System.out.print(guesses[i] + ", "); // comma between guesses
                            }
                        }
                        delay(); // 3s delay

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
                                ghostwriter("Only input y or n!"); // types then deletes
                            }
                        }
                    }
                }
            }
        }
    }

    //this function allows a string to pass through it and
    //then writes it 1 letter at a time
    public static void ghostwriter(String sentence){
        for (int i = 0; i < sentence.length(); i++){
            System.out.print(sentence.charAt(i) + "");
            timer1();
        }
        timer2();
        //deletes 1 letter at a time using \b for backspace
        for (int j = sentence.length() - 1; j > -1; j--){
            System.out.print("\b \b");
            timer1();
        }
    }

    //this function prints the loading screen animation
    public static void loading(){
        String dots = "....";
        for (int i = 0; i < 4; i++){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.print("Loading" + "");
            for (int j = 0; j < dots.length(); j++){
                System.out.print(dots.charAt(j));
                timer1();
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
                    System.out.println("Enter between " + min1 + " and " + max1);
                    timer1();
                    System.out.print("\033[H\033[2J");
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
                timer1();
                System.out.print("\033[H\033[2J");
                System.out.print(prompt);
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

    //function for timer which is for 1/10 of a second
    public static void timer1(){
        try{
            Thread.sleep(100);
        } catch (Exception e) {}
    }

    //function for timer which is for 2 seconds
    public static void timer2(){
        try{
            Thread.sleep(2000);
        } catch (Exception e) {}
    }

    // method to play a sound file
    public static void playSound(String filename){
        File lol = new File(filename);
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(lol));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}