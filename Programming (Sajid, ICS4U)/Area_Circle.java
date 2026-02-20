/*
Name: Sajid Abdullah
Date: Feb 20, 2026
Description:
The program first asks the user for their name and greets them with a welcome message.
then it will ask them for a radius and calculate the area/circumference of a circle.
Resources:
https://www.asciiart.eu/text-to-ascii-art#google_vignette (ASCII art for titles)
https://emojicombos.com/falling-boulder-ascii-art (ASCII art for images)
*/



import java.util.Scanner;
public class Area_Circle {
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
 .--.                                     .-.                                
: .; :                                    : :                                
:    :.--.  .--.  .--.     .--.  ,-.,-. .-' :                                
: :: :: ..'' '_.'' .; ;   ' .; ; : ,. :' .; :                                
:_;:_;:_;  `.__.'`.__,_;  `.__,_;:_;:_;`.__.'                                
                                                                             
                                                                             
.---.            _                .-.                    .--.                
: .; :          :_;              .' `.                  : .-'                
:  _.'.--. .--. .-.,-.,-.,-. .--.`. .'.--. .--.    .--. : `;                 
: :  ' '_.': ..': :: ,. ,. :' '_.': :' '_.': ..'  ' .; :: :                  
:_;  `.__.':_;  :_;:_;:_;:_;`.__.':_;`.__.':_;    `.__.':_;                  
                                                                             
                                                                             
 .--.  _            .-.          .---.                                       
: .--':_;           : :          : .; :                                      
: :   .-..--.  .--. : :   .--.   :  _.'.--.  .--.  .--. .--.  .--.  ,-.,-.,-.
: :__ : :: ..''  ..': :_ ' '_.'  : :   : ..'' .; :' .; :: ..'' .; ; : ,. ,. :
`.__.':_;:_;  `.__.'`.__;`.__.'  :_;   :_;  `.__.'`._. ;:_;  `.__,_;:_;:_;:_;
                                                   .-. :                     
                                                   `._.'                     
                """ + RESET);

        System.out.println(RED + "What is your name?"+ RESET + GREEN);
        String user_name = scan.next();
        System.out.println(RESET + BLUE + "Welcome to the Area and Perimeter of a Circle Program, " + user_name + RESET);

        double pi=3.14;

        System.out.println(PURPLE + "Enter your radius (as integer)" + RESET);
        int user_radius = scan.nextInt();

        double Area = (pi*(user_radius*user_radius));
        System.out.println(GREEN + "The Area is " + (int)Area + RESET);

        double Perimenter = (2*pi*user_radius);
        System.out.println(GREEN + "The Perimeter is " + (int)Perimenter + RESET);




        

    }
}
