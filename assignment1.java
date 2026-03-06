import java.util.Scanner;
import java.util.Random;
/*
Name: Sajid Abdullah
Date: March 4, 2026
Description: This is a math program that has a menu and a sub menu. The menu prompts user to run the math program
or exit the program. The sub menu prompts user to choose either the easy quiz (5 questions) or
a random quiz (5 questions with random numbers each time)

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

        while (decision1) {
            while (true) {
                System.out.print("\033[H\033[2J"); // clears the screen
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

                // if you choose the math game
                if (choice1 == 1) {
                    break;
                }
                // if you exit the program
                else if (choice1 == 2) {
                    System.out.print("\033[H\033[2J"); // clears the screen
                    System.out.println(YELLOW + "Thank you for using my program!" + RESET);
                    delay(); // 3s delay
                    decision1 = false;
                    break;
                } else {
                    System.out.print("\033[H\033[2J"); // clears the screen
                    System.out.println("Input choice 1 or 2: "); // prints if not 1 or 2
                    delay(); // 3s delay
                    System.out.print("\033[H\033[2J"); // clears the screen
                }
            }

            // this goes to the math game sub menu
            if (choice1 == 1) {
                decision2 = true;
                while (decision2) {
                    while (true) {
                        System.out.print("\033[H\033[2J"); // clears the screen
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
2.) Random Quiz        <-- ADD RANDOM QUIZ LOGIC IN THE QUIZ LOOP BELOW
3.) Return to Main Menu
                                                """ + RESET);
                        choice2 = scan.nextInt();

                        // if you choose easy quiz
                        if (choice2 == 1) {
                            break;
                        }
                        // ADD: if you choose random quiz
                        else if (choice2 == 2) {
                            break; // <-- ADD RANDOM QUIZ CODE INSIDE THE while(decision3) LOOP BELOW
                        }
                        // if you choose to go back to the main menu
                        else if (choice2 == 3) {
                            System.out.print("\033[H\033[2J"); // clears the screen
                            System.out.println(YELLOW + "Returning to main menu" + RESET);
                            delay(); // 3s delay
                            decision2 = false;
                            break;
                        } else {
                            System.out.print("\033[H\033[2J"); // clears the screen
                            System.out.println("Input choice 1, 2, or 3: "); // prints if not valid
                            delay(); // 3s delay
                            System.out.print("\033[H\033[2J"); // clears the screen
                        }
                    }

                    if (decision2 == false) {
                        decision3 = false;
                    } else {
                        decision3 = true;
                    }

                    while (decision3) {
                        System.out.print("\033[H\033[2J"); // clears the screen

                        int score = 0;
                        int answer;

                        
                        if (choice2 == 1) { 

                            // ADD YOUR EASY QUIZ ASCII ART HERE
                            System.out.println("ADD EASY QUIZ ASCII");
                            System.out.println("Answer each question. 1 correct answer gives 1 point.");
                            delay(); // 3s delay

                            // Q1: 3 + 6 * 2 = 15
                            System.out.println(YELLOW + "Q1: What is 3 + 6 * 2?" + RESET);
                            System.out.print("Your answer: "); // FIX: print not println so input is on same line
                            answer = scan.nextInt();
                            if (answer == 3 + 6 * 2) {
                                System.out.println(GREEN + "Correct! You got 1 point!" + RESET);
                                score++;
                            } else {
                                System.out.println(RED + "Incorrect! The answer was " + (3 + 6 * 2) + RESET); // FIX: added space before answer
                            }
                            delay();

                            // Q2: 10 + 8 / 2 = 14
                            System.out.println(YELLOW + "Q2: What is 10 + 8 / 2?" + RESET);
                            System.out.print("Your answer: "); // FIX: print not println
                            answer = scan.nextInt();
                            if (answer == 10 + 8 / 2) {
                                System.out.println(GREEN + "Correct! You got 1 point!" + RESET);
                                score++;
                            } else {
                                System.out.println(RED + "Incorrect! The answer was " + (10 + 8 / 2) + RESET); // FIX: added space before answer
                            }
                            delay();

                            // Q3: 4 * 7 - 6 / 3 = 26
                            System.out.println(YELLOW + "Q3: What is 4 * 7 - 6 / 3?" + RESET);
                            System.out.print("Your answer: "); // FIX: print not println
                            answer = scan.nextInt();
                            if (answer == 4 * 7 - 6 / 3) {
                                System.out.println(GREEN + "Correct! You got 1 point!" + RESET);
                                score++;
                            } else {
                                System.out.println(RED + "Incorrect! The answer was " + (4 * 7 - 6 / 3) + RESET); // FIX: added space before answer
                            }
                            delay();

                            // Q4: 2 * ((3 + 11) - 6 * (2 - 8)) = 100
                            System.out.println(YELLOW + "Q4: What is 2 * ((3 + 11) - 6 * (2 - 8))?" + RESET);
                            System.out.print("Your answer: "); // FIX: print not println
                            answer = scan.nextInt();
                            if (answer == 2 * ((3 + 11) - 6 * (2 - 8))) {
                                System.out.println(GREEN + "Correct! You got 1 point!" + RESET);
                                score++;
                            } else {
                                System.out.println(RED + "Incorrect! The answer was " + (2 * ((3 + 11) - 6 * (2 - 8))) + RESET); // FIX: was showing wrong answer (Q3's answer)
                            }
                            delay();

                            // Q5: 13 + 23 - 9 / 3 = 33
                            System.out.println(YELLOW + "Q5: What is 13 + 23 - 9 / 3?" + RESET);
                            System.out.print("Your answer: "); // FIX: print not println
                            answer = scan.nextInt();
                            if (answer == 13 + 23 - 9 / 3) {
                                System.out.println(GREEN + "Correct! You got 1 point!" + RESET);
                                score++;
                            } else {
                                System.out.println(RED + "Incorrect! The answer was " + (13 + 23 - 9 / 3) + RESET); // FIX: added space before answer
                            }
                            delay();

                            // ADD YOUR SCORE DISPLAY HERE (ex. "Your score: " + score + " / 5")

                        }

                        // =============================================
                        // RANDOM QUIZ - ADD YOUR RANDOM QUIZ HERE
                        // choice2 == 2
                        // use x, y, z, w variables with rand.nextInt()
                        // example: x = rand.nextInt(1, 10);
                        //          System.out.println("What is " + x + " * " + y + "?");
                        // =============================================
                        else if (choice2 == 2) {
                            // ADD RANDOM QUIZ ASCII ART HERE
                            // ADD 5 RANDOM QUESTIONS HERE
                            // ADD SCORE DISPLAY HERE
                        }

                        // runs the quiz again or returns back to the math sub menu
                        while (true) {
                            System.out.println(YELLOW + "Would you like to run the program again, y or n?" + RESET);
                            String playAgain = scan.next().toLowerCase(); // FIX: renamed from "answer" to "playAgain" - cant have two variables with same name
                            if (playAgain.equals("y")) {
                                break;
                            } else if (playAgain.equals("n")) {
                                decision3 = false;
                                break;
                            } else {
                                System.out.print("\033[H\033[2J"); // clears the screen
                                System.out.println("Only input y or n!");
                                delay(); // 3s delay
                                System.out.print("\033[H\033[2J"); // clears the screen
                            }
                        }
                    }
                }
            }
        }
    }

    // function to delay by 3 seconds
    public static void delay() {
        try {
            Thread.sleep(3000); // 3000ms = 3 seconds
        } catch (Exception e) {
        }
        System.out.flush();
    }
}