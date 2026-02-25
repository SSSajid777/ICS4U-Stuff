import java.util.Scanner;

public class homework_2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String RESET = "\u001B[0m"; // Resets the colour back to default
        String BLACK = "\u001B[30m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String BLUE = "\u001B[34m";
        String PURPLE = "\u001B[35m";
        String CYAN = "\u001B[36m";
        String WHITE = "\u001B[37m";
        // prints ASCII art title

        System.out.println(YELLOW + """
 .--.                .-.                                
: .--'               : :                                
: : _ .--.  .--.   .-' : .--.                           
: :; :: ..'' .; ; ' .; :' '_.'                          
`.__.':_;  `.__,_;`.__.'`.__.'                          
                                                        
                                                        
 .--.        .-.              .-.         .-.           
: .--'       : :              : :        .' `.          
: :    .--.  : :   .--. .-..-.: :   .--. `. .'.--. .--. 
: :__ ' .; ; : :_ '  ..': :; :: :_ ' .; ; : :' .; :: ..'
`.__.'`.__,_;`.__;`.__.'`.__.'`.__;`.__,_;:_;`.__.':_;                          
           
                """ + RESET);

        System.out.println(RED + "What is your name?"+ RESET + GREEN);
        String user_name = scan.next();
        System.out.println(RESET + BLUE + "Welcome to the Grade Calculator Program, " + user_name + RESET);
        
        System.out.println("Please enter your test percentage (without percentage sign)");
        int grade = scan.nextInt();

        if (grade >= 90 && grade <= 100) {
            System.out.println("Level 4+");

        }
        else if (grade >= 80 && grade <= 89) {
            System.out.println("Level 4");

        }
        else if (grade >= 70 && grade < 79) {
            System.out.println("Level 3");

        }
        else if (grade >= 60 && grade < 69) {
            System.out.println("Level 2");

        }
        else if (grade < 60 && grade >= 0) {
            System.out.println(" Level 1 - Keep practicing!");

        }
        else if (grade < 0 || grade > 100) {
            System.out.println("Invalid Grade");
        
        }
        


        System.out.println(YELLOW + """
.---.                                          .-.
: .; :                                         : :
:  _.'.--.   .--.  .--. .-..-..-. .--. .--.  .-' :
: :  ' .; ; `._-.'`._-.': `; `; :' .; :: ..'' .; :
:_;  `.__,_;`.__.'`.__.'`.__.__.'`.__.':_;  `.__.'
                                                  
                                                  
 .--.    .-.       _                              
: .; :   : :      :_;                             
:    : .-' :.-..-..-. .--.  .--. .--.             
: :: :' .; :: `; :: :`._-.'' .; :: ..'            
:_;:_;`.__.'`.__.':_;`.__.'`.__.':_;                                     
           
                """ + RESET);

        System.out.println(RED + "What is your name?"+ RESET + GREEN);
        String user_name_2 = scan.next();
        System.out.println(RESET + BLUE + "Welcome to the Password Adviser, " + user_name + RESET);
        
        System.out.println("Please enter your password");
        String password= scan.next();
        if (password.length() < 6) {
            System.out.println("Your password is too short, please enter at least 6 characters");
        }
        else if (password.length() >= 6 && password.length() <= 10) {
            System.out.println("Your password is moderate strength, enter 10 characters or more for a strong password");
        }
        else if (password.length() > 10) {
            System.out.println("Your password is strong");
        }
        else {
            System.out.println("Error: please enter a password");
        }
        

    }
}