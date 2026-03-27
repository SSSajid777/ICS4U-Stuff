/*
Name: Sajid Abdullah
Date: March 26, 2026
Description:
Welcomes the user after asking for their name.  The asks them for
the length and width of a rectangle.  Then it calculates and outputs the area
and perimeter for the rectangle.  
Resources:
https://www.asciiart.eu/text-to-ascii-art#google_vignette (ASCII art for titles)
In-Class Examples and Template


*/
import java.util.Scanner;
import java.util.Random;

public class Assignment2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice1, choice2;
        boolean decision1, decision2, decision3;
        decision1 = true;
        while (decision1) {
            while (true) {
                System.out.print("\033[H\033[2J");// clears the screen
                // add some ASCII art here instead of this statement
                System.out.println("""
                        Main Menu


                        1.) Hi Lo Guessing Game
                        2.) Exit Proram
                                """);
                choice1 = scan.nextInt();//main menu input
                //if you choose the math game
                if (choice1 == 1) {
                    break;
                }
                //if you exit the program
                else if (choice1 == 2) {
                    System.out.print("\033[H\033[2J");// clears the screen
                    System.out.println("Thank you for using my program!");
                    delay();// 3s delay
                    decision1 = false;
                    break;
                } else {
                    System.out.print("\033[H\033[2J");// clears the screen
                    System.out.println("Input choice 1 or 2: ");//prints if not 1 or 2
                    delay();// 3s delay
                    System.out.print("\033[H\033[2J");// clears the screen
                }
            }
            //this goes to the math game sub menu
            if (choice1 == 1) {
                decision2 = true;
                while (decision2) {
                    while (true) {
                        System.out.print("\033[H\033[2J");// clears the screen
                        //add some ASCII art here instead of this statement
                        System.out.println("""
                                Math Game Menu


                                1.) Run Math Game
                                2.) Return to Main Menu
                                                """);
                        choice2 = scan.nextInt();
                        //if you choose to run the math game
                        if (choice2 == 1) {
                            break;
                        }
                        //if you choose to go back to the main menu
                        else if (choice2 == 2) {
                            System.out.print("\033[H\033[2J");// clears the screen
                            System.out.println("Returning to main menu");
                            delay();// 3s delay
                            decision2 = false;
                            break;
                        } else {
                            System.out.print("\033[H\033[2J");// clears the screen
                            System.out.println("Input choice 1 or 2: ");//prints if not 1 or 2
                            delay();// 3s delay
                            System.out.print("\033[H\033[2J");// clears the screen
                        }


                    }
                    if (decision2 == false) {
                        decision3 = false;
                    } else {
                        decision3 = true;
                    }
                    while (decision3) {
                        System.out.print("\033[H\033[2J");// clears the screen
                        //this is where you will put your math game
                        System.out.println("This is where you are going to put your math program");
                        delay();// 3s delay
                        //runs the math game or returns back to the math sub menu
                        while (true) {
                            System.out.println("Would you like to run the program again, y or n?");
                            String answer = scan.next().toLowerCase();
                            if (answer.equals("y")) {
                                break;
                            } else if (answer.equals("n")) {
                                decision3 = false;
                                break;
                            } else {
                                System.out.print("\033[H\033[2J");// clears the screen
                                System.out.println("Only input y or n!");
                                delay();// 3s delay
                                System.out.print("\033[H\033[2J");// clears the screen
                            }
                        }
                    }


                }


            }
        }
    }
    //function to delay by 3 seconds
    public static void delay() {
        // a delay by 1 second so 1000ms = 1s
        try {
            Thread.sleep(3000);// 2s delay
        } catch (Exception e) {
        }
        System.out.flush();
    }
}
