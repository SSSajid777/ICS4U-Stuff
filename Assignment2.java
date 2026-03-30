/*
Name: Sajid Abdullah
Date: March 26, 2026
Description: This is a Hi-Lo guessing game program with a main menu and sub menu.
The user picks a difficulty (Easy, Medium, Hard, or Custom) and tries to guess a random number.
Easy has unlimited guesses (1-20), Medium has 10 guesses (1-100), Hard has 3 guesses (1-1000),
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

    public static String validInput; // global variable for error handling

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

                // ghostwriter types out the menu options
                ghostwriter(BLUE + "        1.) Hi-Lo Guessing Game" + RESET);
                ghostwriter(BLUE + "        2.) Exit Program" + RESET);
                System.out.println("");

                String test = scan.next();
                errorCheck(test); // call to method
                choice1 = Integer.parseInt(validInput);

                // if you choose the game
                if (choice1 == 1) {
                    break;
                } // if you exit the program
                else if (choice1 == 2) {
                    System.out.print("\033[H\033[2J"); // clears the screen
                    ghostwriter("Thank you for using my program!");
                    delay(); // 3s delay
                    decision1 = false;
                    break;
                } else {
                    System.out.print("\033[H\033[2J"); // clears the screen
                    ghostwriter("Input choice 1 or 2!"); // prints if not 1 or 2
                    delay(); // 3s delay
                    System.out.print("\033[H\033[2J"); // clears the screen
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

                        // ghostwriter types out the sub menu options
                        ghostwriter(BLUE + "        1.) Easy   (1 - 20,   unlimited guesses)" + RESET);
                        ghostwriter(BLUE + "        2.) Medium (1 - 100,  10 guesses)" + RESET);
                        ghostwriter(BLUE + "        3.) Hard   (1 - 1000, 3 guesses)" + RESET);
                        ghostwriter(BLUE + "        4.) Custom (you choose range and guesses)" + RESET);
                        ghostwriter(BLUE + "        5.) Return to Main Menu" + RESET);
                        System.out.println("");

                        String test = scan.next();
                        errorCheck(test); // call to method
                        choice2 = Integer.parseInt(validInput);

                        // if you choose easy, medium, hard, or custom
                        if (choice2 == 1 || choice2 == 2 || choice2 == 3 || choice2 == 4) {
                            break;
                        } // if you return to main menu
                        else if (choice2 == 5) {
                            System.out.print("\033[H\033[2J"); // clears the screen
                            ghostwriter("Returning to main menu");
                            delay(); // 3s delay
                            decision2 = false;
                            break;
                        } else {
                            System.out.print("\033[H\033[2J"); // clears the screen
                            ghostwriter("Input choice 1, 2, 3, 4, or 5!"); // prints if not 1-5
                            delay(); // 3s delay
                            System.out.print("\033[H\033[2J"); // clears the screen
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

                        // easy mode settings
                        if (choice2 == 1) {
                            minNumber = 1;
                            maxNumber = 20;
                            maxGuesses = 100; // effectively unlimited
                            difficultyName = "Easy";
                        } else {
                            // placeholder for medium, hard, custom coming soon
                            minNumber = 1;
                            maxNumber = 20;
                            maxGuesses = 100;
                            difficultyName = "Easy";
                        }

                        int secretNumber = rand.nextInt(minNumber, maxNumber + 1); // random number to guess
                        int guessCount = 0;
                        int[] guesses = new int[maxGuesses]; // array to store guesses
                        boolean won = false;

                        // show difficulty info
                        ghostwriter(PURPLE + "Difficulty: " + difficultyName + RESET);
                        ghostwriter("Guess a number between " + minNumber + " and " + maxNumber);
                        ghostwriter("You have unlimited guesses!");
                        System.out.println("");
                        delay(); // 3s delay

                        // guessing loop
                        while (guessCount < maxGuesses) {
                            System.out.print(YELLOW + "Enter your guess: " + RESET);
                            String test = scan.next();
                            errorCheck(test); // call to method
                            int guess = Integer.parseInt(validInput);

                            // check if guess is within range, does not count as a guess
                            if (guess < minNumber || guess > maxNumber) {
                                ghostwriter(RED + "Enter a number between " + minNumber + " and " + maxNumber + "!" + RESET);
                                continue; // skips the rest and asks again
                            }

                            guesses[guessCount] = guess; // store guess in array
                            guessCount++;

                            // check if guess is correct, higher, or lower
                            if (guess == secretNumber) {
                                ghostwriter(GREEN + "Correct!" + RESET);
                                playSound("correct_sound.wav"); // play correct sound
                                won = true;
                                break;
                            } else if (guess < secretNumber) {
                                ghostwriter(BLUE + "Higher!" + RESET);
                            } else {
                                ghostwriter(RED + "Lower!" + RESET);
                            }
                        }

                        // if player ran out of guesses
                        if (!won) {
                            ghostwriter(RED + "Out of guesses! The answer was " + secretNumber + RESET);
                            playSound("incorrect_sound.wav"); // play incorrect sound
                        }

                        // display all guesses from array
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
                            ghostwriter("Would you like to play again, y or n?");
                            String playAgain = scan.next().toLowerCase();
                            if (playAgain.equals("y")) {
                                break; // loops back to play again
                            } else if (playAgain.equals("n")) {
                                decision3 = false; // exits game loop, goes back to sub menu
                                break;
                            } else {
                                System.out.print("\033[H\033[2J"); // clears the screen
                                ghostwriter("Only input y or n!");
                                delay(); // 3s delay
                                System.out.print("\033[H\033[2J"); // clears the screen
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
            timer();
        }
        System.out.println();//goes to the next line
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
                timer();
            }
        System.out.println();//goes to the next line
        }
    }

    // method for error handling input
    public static void errorCheck(String x){
        Scanner scan = new Scanner(System.in);
        while (true){
            try {
                Integer.parseInt(x); // tries to convert string to int
                validInput = x;
                break;
            } catch (Exception e) {
                // if it is not a number it goes here
                System.out.println("Numbers only please!");
                System.out.print("Try again: ");
                x = scan.next();
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
    public static void timer(){
        try{
            Thread.sleep(100);
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