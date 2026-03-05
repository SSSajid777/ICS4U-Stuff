import java.util.Scanner;
import java.util.Random;
/*
Name: Sajid Abdullah
Date: March 4, 2026asy  
Description:This is a math program that has a menu and a sub menu. The menu prompts user to run the math program  
or exit the program. The sub menu prompts user to choose either the easy quiz (5 questions) or
a random quiz (3 questions with random numbers each time)

Resources:
https://www.asciiart.eu/text-to-ascii-art#google_vignette (ASCII art for titles)

prog

*/
//this is a template for assignment 1
public class assignment1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand= new Random();

        String RESET = "\u001B[0m"; // Resets the colour back to default
        String BLACK = "\u001B[30m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String BLUE = "\u001B[34m";
        String PURPLE = "\u001B[35m";
        String CYAN = "\u001B[36m";
        String WHITE = "\u001B[37m";

        int choice1, choice2;
        boolean decision1, decision2, decision3;
        decision1 = true;
        while (decision1) {
            while (true) {
                System.out.print("\033[H\033[2J");// clears the screen
                System.out.println(PURPLE+"""
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
2.) Exit Proram
                                """+RESET);
                choice1 = scan.nextInt();//main menu input
                //if you choose the math game
                if (choice1 == 1) {
                    break;
                }
                //if you exit the program
                else if (choice1 == 2) {
                    System.out.print("\033[H\033[2J");// clears the screen
                    System.out.println(YELLOW + "Thank you for using my program!"+ RESET);
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

1.) Run Math Game
2.) Return to Main Menu
                                                """+ RESET);
                        choice2 = scan.nextInt();
                        //if you choose to run the math game
                        if (choice2 == 1) {
                            break;
                        }
                        //if you choose to go back to the main menu
                        else if (choice2 == 2) {
                            System.out.print("\033[H\033[2J");// clears the screen
                            System.out.println(YELLOW + "Returning to main menu" +RESET);
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
                        int score=0;
                        int answer;
                        if (choice2==choice1){
                            System.out.println("ADD EASY QUIZ ASCII");
                            System.out.println("Answer each question. 1 correct answer gives 1 point.");
                        }
                        delay();// 3s delay
                        System.out.println(YELLOW+"Q1: What is 3 + 6 * 2?" + RESET);
                        System.out.println("Your answer: ");
                        answer=scan.nextInt();
                        if (answer == 3 + 6 * 2){
                            System.out.println(GREEN + "Correct! You got 1 point!" + RESET);
                            score++;
                        } 
                        else{
                            System.out.println(RED + "Incorrect! The answer was" + (3 + 6 * 2) + RESET);
                        }
                        delay();
                        System.out.println(YELLOW+"Q2: What is 10 + 8 /2 ? (Round to nearest whole number" + RESET);
                        System.out.println("Your answer: ");
                        answer=scan.nextInt();
                        if (answer == 10 + 8 / 2){
                            System.out.println(GREEN + "Correct! You got 1 point!" + RESET);
                            score++;
                        } 
                        else{
                            System.out.println(RED + "Incorrect! The answer was" + (10 + 8 / 2) + RESET);
                        }
                        delay();
                        System.out.println(YELLOW+"Q3: What is 4 * 7 - 6 / 3? (Round to nearest whole number" + RESET);
                        System.out.println("Your answer: ");
                        answer=scan.nextInt();
                        if (answer == 4 * 7 - 6 / 3){
                            System.out.println(GREEN + "Correct! You got 1 point!" + RESET);
                            score++;
                        } 
                        else{
                            System.out.println(RED + "Incorrect! The answer was" + (4 * 7 - 6 / 3) + RESET);
                        }
                        delay();
                        System.out.println(YELLOW+"Q4: What is 2 * ((3 + 11) - 6 * (2 - 8)) ?"+ RESET);
                        System.out.println("Your answer: ");
                        answer=scan.nextInt();
                        if (answer == 2 * ((3 + 11) - 6 * (2 - 8))){
                            System.out.println(GREEN + "Correct! You got 1 point!" + RESET);
                            score++;
                        } 
                        else{
                            System.out.println(RED + "Incorrect! The answer was" + (4 * 7 - 6 / 3) + RESET);
                        }
                        delay();



                        //runs the math game or returns back to the math sub menu
                        while (true) {
                            System.out.println(YELLOW + "Would you like to run the program again, y or n?" +RESET);
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
