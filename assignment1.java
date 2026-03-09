import java.io.File;
import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/*
Name: Sajid Abdullah
Date: March 4, 2026
Description: This is a math program that has a menu and a sub menu. The menu prompts user to run the math program
or exit the program. The sub menu prompts user to choose either the easy quiz (5 questions),
a random quiz (5 questions with random numbers each time), or view the instructions.

Resources:
https://www.asciiart.eu/text-to-ascii-art#google_vignette (ASCII art for titles)
*/

public class assignment1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        String RESET  = "\u001B[0m";
        String BLACK  = "\u001B[30m";
        String RED    = "\u001B[31m";
        String GREEN  = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String BLUE   = "\u001B[34m";
        String PURPLE = "\u001B[35m";
        String CYAN   = "\u001B[36m";
        String WHITE  = "\u001B[37m";

        int choice1, choice2;
        boolean decision1, decision2, decision3;
        decision1 = true;

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


1.) Math Program
2.) Exit Program
                                """ + RESET);
                choice1 = scan.nextInt(); // main menu input

                // if you choose the math program
                if (choice1 == 1) {
                    break;
                }
                // if you exit the program
                else if (choice1 == 2) {
                    System.out.print("\033[H\033[2J"); // clears the screen
                    System.out.println(CYAN + "Thank you for using my program!" + RESET);
                    delay(); // 3s delay
                    decision1 = false;
                    break;
                }
                else {
                    System.out.print("\033[H\033[2J"); // clears the screen
                    System.out.println(RED + "Input choice 1 or 2!" + RESET); // prints if not 1 or 2
                    delay(); // 3s delay
                    System.out.print("\033[H\033[2J"); // clears the screen
                }
            }

            // goes to the math game sub menu
            if (choice1 == 1) {
                decision2 = true;
                while (decision2) {
                    while (true) {
                        System.out.print("\033[H\033[2J"); // clears the screen

                        // math menu ASCII art
                        System.out.println(PURPLE + """
.-..-.       .-. .-.      .--.                       
: `' :      .' `.: :     : .--'                      
: .. : .--. `. .': `-.   : : _  .--.  ,-.,-.,-. .--. 
: :; :' .; ; : : : .. :  : :; :' .; ; : ,. ,. :' '_.'
:_;:_;`.__,_;:_; :_;:_;  `.__.'`.__,_;:_;:_;:_;`.__.'
                                                     
.-..-.                                               
: `' :                                               
: .. : .--. ,-.,-..-..-.                             
: :; :' '_.': ,. :: :; :                             
:_;:_;`.__.':_;:_;`.__.'                             

1.) Easy Quiz
2.) Random Quiz
3.) Instructions
4.) Return to Main Menu
                                                """ + RESET);
                        choice2 = scan.nextInt();

                        // if you choose easy quiz
                        if (choice2 == 1) {
                            break;
                        }
                        // if you choose random quiz
                        else if (choice2 == 2) {
                            break;
                        }
                        // if you choose instructions
                        else if (choice2 == 3) {
                            System.out.print("\033[H\033[2J"); // clears the screen

                            // instructions ASCII art
                            System.out.println(CYAN + """
 .--.         .               .-.   .          
: .--'        |              .' `.  |           
: `;  .--. .--.  .--.  .--.  `. .'.-+- .--. .-.
: :  ' .; :: ..'' .; ;' '_.'  : : : : ' .; :: :
`.__'`.__.':_; `.__.;`.__.'   :_; `-'-'`.__.'`-'
""" + RESET);

                            System.out.println(YELLOW + "How to play:" + RESET);
                            System.out.println("- Choose Easy Quiz for 5 set questions");
                            System.out.println("- Choose Random Quiz for 5 random questions");
                            System.out.println("- Type your answer and press enter");
                            System.out.println("- You get 1 point for each correct answer");
                            System.out.println("- At the end you can play again or go back");
                            System.out.println("");
                            System.out.println(YELLOW + "BEDMAS Rules:" + RESET);
                            System.out.println("B - Brackets first       ex: (3 + 2) * 4 = 20");
                            System.out.println("E - Exponents next       ex: 2^3 = 8");
                            System.out.println("D - Division             ex: 8 / 2 = 4");
                            System.out.println("M - Multiplication       ex: 3 * 4 = 12");
                            System.out.println("A - Addition             ex: 5 + 3 = 8");
                            System.out.println("S - Subtraction last     ex: 9 - 4 = 5");
                            System.out.println("");
                            System.out.println(CYAN + "D and M have equal priority, solve left to right" + RESET);
                            System.out.println(CYAN + "A and S have equal priority, solve left to right" + RESET);
                            delay(); // 3s delay
                            // does not break so loops back to math menu
                        }
                        // if you choose to return to main menu
                        else if (choice2 == 4) {
                            System.out.print("\033[H\033[2J"); // clears the screen
                            System.out.println(YELLOW + "Returning to main menu" + RESET);
                            delay(); // 3s delay
                            decision2 = false;
                            break;
                        }
                        else {
                            System.out.print("\033[H\033[2J"); // clears the screen
                            System.out.println(RED + "Input choice 1, 2, 3, or 4!" + RESET);
                            delay(); // 3s delay
                            System.out.print("\033[H\033[2J"); // clears the screen
                        }
                    }

                    // if user picked return to main menu skip the quiz, otherwise run it
                    if (decision2 == false) {
                        decision3 = false;
                    }
                    else {
                        decision3 = true;
                    }

                    // quiz loop
                    while (decision3) {
                        System.out.print("\033[H\033[2J"); // clears the screen

                        int score = 0;
                        int answer;
                        int x, y, z, w; // variables reused for all random questions

                        // easy quiz
                        if (choice2 == 1) {

                            // easy quiz ASCII art
                            System.out.println(CYAN + """
.----.                  .----.   .        
: .-' .--. .-..-. .--. : .-' .-+- .-.  
: `-. : ..': `; `.' .; ;: `-. : : :' ._.'
`----'`._.' `.__.`.__,_;`----'`-'-'`.__.
""" + RESET);

                            System.out.println(CYAN + "Answer each question. 1 correct answer gives 1 point." + RESET);
                            delay(); // 3s delay

                            // Q1: 3 + 6 * 2 = 15
                            // multiply first: 6*2=12, then add: 3+12=15
                            System.out.println(YELLOW + "Q1: What is 3 + 6 * 2?" + RESET);
                            System.out.print("Your answer: ");
                            answer = scan.nextInt();
                            if (answer == 3 + 6 * 2) {
                                System.out.println(GREEN + "Correct! You got 1 point!" + RESET);
                                score++;
                                playSound("correct_sound.wav"); // play correct sound
                            }
                            else {
                                System.out.println(RED + "Incorrect! The answer was " + (3 + 6 * 2) + RESET);
                                playSound("incorrect_sound.wav"); // play incorrect sound
                            }
                            delay();

                            // Q2: 10 + 8 / 2 = 14
                            // divide first: 8/2=4, then add: 10+4=14
                            System.out.println(YELLOW + "Q2: What is 10 + 8 / 2?" + RESET);
                            System.out.print("Your answer: ");
                            answer = scan.nextInt();
                            if (answer == 10 + 8 / 2) {
                                System.out.println(GREEN + "Correct! You got 1 point!" + RESET);
                                score++;
                                playSound("correct_sound.wav");
                            }
                            else {
                                System.out.println(RED + "Incorrect! The answer was " + (10 + 8 / 2) + RESET);
                                playSound("incorrect_sound.wav");
                            }
                            delay();

                            // Q3: 4 * 7 - 6 / 3 = 26
                            // divide first: 6/3=2, multiply: 4*7=28, then subtract: 28-2=26
                            System.out.println(YELLOW + "Q3: What is 4 * 7 - 6 / 3?" + RESET);
                            System.out.print("Your answer: ");
                            answer = scan.nextInt();
                            if (answer == 4 * 7 - 6 / 3) {
                                System.out.println(GREEN + "Correct! You got 1 point!" + RESET);
                                score++;
                                playSound("correct_sound.wav");
                            }
                            else {
                                System.out.println(RED + "Incorrect! The answer was " + (4 * 7 - 6 / 3) + RESET);
                                playSound("incorrect_sound.wav");
                            }
                            delay();

                            // Q4: 2 * ((3 + 11) - 6 * (2 - 8)) = 100
                            // inner brackets: (3+11)=14, (2-8)=-6
                            // then: 6*(-6)=-36, 14-(-36)=50, 2*50=100
                            System.out.println(YELLOW + "Q4: What is 2 * ((3 + 11) - 6 * (2 - 8))?" + RESET);
                            System.out.print("Your answer: ");
                            answer = scan.nextInt();
                            if (answer == 2 * ((3 + 11) - 6 * (2 - 8))) {
                                System.out.println(GREEN + "Correct! You got 1 point!" + RESET);
                                score++;
                                playSound("correct_sound.wav");
                            }
                            else {
                                System.out.println(RED + "Incorrect! The answer was " + (2 * ((3 + 11) - 6 * (2 - 8))) + RESET);
                                playSound("incorrect_sound.wav");
                            }
                            delay();

                            // Q5: 13 + 23 - 9 / 3 = 33
                            // divide first: 9/3=3, then left to right: 13+23=36, 36-3=33
                            System.out.println(YELLOW + "Q5: What is 13 + 23 - 9 / 3?" + RESET);
                            System.out.print("Your answer: ");
                            answer = scan.nextInt();
                            if (answer == 13 + 23 - 9 / 3) {
                                System.out.println(GREEN + "Correct! You got 1 point!" + RESET);
                                score++;
                                playSound("correct_sound.wav");
                            }
                            else {
                                System.out.println(RED + "Incorrect! The answer was " + (13 + 23 - 9 / 3) + RESET);
                                playSound("incorrect_sound.wav");
                            }
                            delay();

                            // easy quiz score display
                            System.out.println(CYAN + "Your score: " + score + " / 5" + RESET);
                            if (score == 5) {
                                System.out.println(GREEN + "Perfect score! Amazing job!" + RESET);
                            }
                            else if (score >= 3) {
                                System.out.println(YELLOW + "Good work! Keep practising!" + RESET);
                            }
                            else {
                                System.out.println(RED + "Keep studying, you will get it!" + RESET);
                            }
                            delay();
                        }

                        // random quiz
                        else if (choice2 == 2) {

                            // random quiz ASCII art
                            System.out.println(PURPLE + """
.-.              .---.   .        
: :              : .--'  .-+- .-.  
: `-.  .--.  .--.: `--.  : :':._.'
: .. :' .; ;' ._.': ..'  : : `.__.;
:_;:_;`.__,_;`.__.`---'  `-'-'`.__.
""" + RESET);

                            System.out.println(PURPLE + "5 random questions - different every time! 1 point each." + RESET);
                            delay(); // 3s delay

                            // Q1: x * y + z
                            // multiply first then add, always a whole number
                            x = rand.nextInt(1, 10);
                            y = rand.nextInt(1, 10);
                            z = rand.nextInt(1, 10);
                            System.out.println(YELLOW + "Q1: What is " + x + " * " + y + " + " + z + " ?" + RESET);
                            System.out.print("Your answer: ");
                            answer = scan.nextInt();
                            if (answer == (x * y + z)) {
                                System.out.println(GREEN + "Correct! +1 point" + RESET);
                                score++;
                                playSound("correct_sound.wav");
                            }
                            else {
                                System.out.println(RED + "Incorrect! The answer was " + (x * y + z) + RESET);
                                playSound("incorrect_sound.wav");
                            }
                            delay();

                            // Q2: (x + y) * z
                            // brackets first then multiply, always a whole number
                            x = rand.nextInt(1, 10);
                            y = rand.nextInt(1, 10);
                            z = rand.nextInt(1, 10);
                            System.out.println(YELLOW + "Q2: What is (" + x + " + " + y + ") * " + z + " ?" + RESET);
                            System.out.print("Your answer: ");
                            answer = scan.nextInt();
                            if (answer == ((x + y) * z)) {
                                System.out.println(GREEN + "Correct! +1 point" + RESET);
                                score++;
                                playSound("correct_sound.wav");
                            }
                            else {
                                System.out.println(RED + "Incorrect! The answer was " + ((x + y) * z) + RESET);
                                playSound("incorrect_sound.wav");
                            }
                            delay();

                            // Q3: x * y + z * w
                            // both multiplications done first then added
                            x = rand.nextInt(1, 10);
                            y = rand.nextInt(1, 10);
                            z = rand.nextInt(1, 10);
                            w = rand.nextInt(1, 10);
                            System.out.println(YELLOW + "Q3: What is " + x + " * " + y + " + " + z + " * " + w + " ?" + RESET);
                            System.out.print("Your answer: ");
                            answer = scan.nextInt();
                            if (answer == (x * y + z * w)) {
                                System.out.println(GREEN + "Correct! +1 point" + RESET);
                                score++;
                                playSound("correct_sound.wav");
                            }
                            else {
                                System.out.println(RED + "Incorrect! The answer was " + (x * y + z * w) + RESET);
                                playSound("incorrect_sound.wav");
                            }
                            delay();

                            // Q4: x * (y + z) - w
                            // brackets first then multiply then subtract
                            x = rand.nextInt(2, 10);
                            y = rand.nextInt(2, 10);
                            z = rand.nextInt(1, 10);
                            w = rand.nextInt(1, 5);
                            System.out.println(YELLOW + "Q4: What is " + x + " * (" + y + " + " + z + ") - " + w + " ?" + RESET);
                            System.out.print("Your answer: ");
                            answer = scan.nextInt();
                            if (answer == (x * (y + z) - w)) {
                                System.out.println(GREEN + "Correct! +1 point" + RESET);
                                score++;
                                playSound("correct_sound.wav");
                            }
                            else {
                                System.out.println(RED + "Incorrect! The answer was " + (x * (y + z) - w) + RESET);
                                playSound("incorrect_sound.wav");
                            }
                            delay();

                            // Q5: (x + y) * (z + w)
                            // both brackets solved first then multiplied
                            x = rand.nextInt(1, 8);
                            y = rand.nextInt(1, 8);
                            z = rand.nextInt(1, 8);
                            w = rand.nextInt(1, 8);
                            System.out.println(YELLOW + "Q5: What is (" + x + " + " + y + ") * (" + z + " + " + w + ") ?" + RESET);
                            System.out.print("Your answer: ");
                            answer = scan.nextInt();
                            if (answer == ((x + y) * (z + w))) {
                                System.out.println(GREEN + "Correct! +1 point" + RESET);
                                score++;
                                playSound("correct_sound.wav");
                            }
                            else {
                                System.out.println(RED + "Incorrect! The answer was " + ((x + y) * (z + w)) + RESET);
                                playSound("incorrect_sound.wav");
                            }
                            delay();

                            // random quiz score display
                            System.out.println(CYAN + "Your score: " + score + " / 5" + RESET);
                            if (score == 5) {
                                System.out.println(GREEN + "Perfect! You nailed all 5!" + RESET);
                            }
                            else if (score >= 3) {
                                System.out.println(YELLOW + "Nice work! Almost there!" + RESET);
                            }
                            else {
                                System.out.println(RED + "Keep practising, try again!" + RESET);
                            }
                            delay();
                        }

                        // ask user to run quiz again or go back to math menu
                        while (true) {
                            System.out.println(YELLOW + "Would you like to run the program again, y or n?" + RESET);
                            String playAgain = scan.next().toLowerCase();
                            if (playAgain.equals("y")) {
                                break; // loops back to run quiz again
                            }
                            else if (playAgain.equals("n")) {
                                decision3 = false; // exits quiz loop, goes back to math menu
                                break;
                            }
                            else {
                                System.out.print("\033[H\033[2J"); // clears the screen
                                System.out.println(RED + "Only input y or n!" + RESET);
                                delay(); // 3s delay
                                System.out.print("\033[H\033[2J"); // clears the screen
                            }
                        }
                    } // end quiz loop
                } // end math menu loop
            } // end if choice1 == 1
        } // end main menu loop
    } // end main

    // delay method - pauses for 3 seconds
    public static void delay() {
        try {
            Thread.sleep(3000); // 3000ms = 3 seconds
        } catch (Exception e) {
        }
        System.out.flush();
    }

    public static void playSound(String filename) {
    File soundFile = new File(filename);
    System.out.println(soundFile.getAbsolutePath()); // shows you where Java is looking
    try {
        Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(soundFile));
        clip.start();
        Thread.sleep(clip.getMicrosecondLength() / 1000);
    }
    catch (Exception e) {
        e.printStackTrace();
    }
}

} 