//This is a header with single lines
//Name: Sajid
//Date: Feb 12, 2026
//Description: This is a sample header 

/*
This is a header with multi lines
Name: Sajid
Date: Feb 12, 2026
Description: this is a sample header
 */
public class commenting {

    public static void main(String[] args) {

        // Source - https://stackoverflow.com/a/5762502
        // Posted by WhiteFang34, modified by community. See post 'Timeline' for change
        // history
        // Retrieved 2026-02-18, License - CC BY-SA 3.0

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

        // int l=3;
        // int w=4;
        System.out.println(YELLOW + """
                 .--.                            .--.
                : .; :                          : .-'
                :    :.--.  .--.  .--.     .--. : `;    .--.
                : :: :: ..'' '_.'' .; ;   ' .; :: :    ' .; ;
                :_;:_;:_;  `.__.'`.__,_;  `.__.':_;    `.__,_;


                .---.             .-.                   .-.
                : .; :           .' `.                  : :
                :   .' .--.  .--.`. .'.--.  ,-.,-. .--. : :   .--.
                : :.`.' '_.''  ..': :' .; ; : ,. :' .; :: :_ ' '_.'
                :_;:_;`.__.'`.__.':_;`.__,_;:_;:_;`._. ;`.__;`.__.'
                                                   .-. :
                                                   `._.'
                        """ + RESET);
        int l = 3, w = 4;
        System.out.println(
                RED + "The area of the rectangle with length " + l + " and width " + w + " is " + (l * w) + RESET);
        String first_name = "Sajid"; // initializes a string variable called first_name
        double pi = 3.14; // creates a real variable called pi
        int num = 10; // creates an integer called num

        System.out.println("1.) item 1");
        System.out.println("2.) item 2");
        System.out.println("3.) item 3");

        System.out.println("1.) item 1\n2.) item 2\n3.) item 3"); //prints on 1 line using \n which means a new line


        System.out.println("Apple\tOrange\tPear\tBanana"); //this is a tab space between strings

    }
}
