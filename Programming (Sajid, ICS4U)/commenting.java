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
// Posted by WhiteFang34, modified by community. See post 'Timeline' for change history
// Retrieved 2026-02-18, License - CC BY-SA 3.0

String ANSI_RESET = "\u001B[0m";
String ANSI_BLACK = "\u001B[30m";
String ANSI_RED = "\u001B[31m";
String ANSI_GREEN = "\u001B[32m";
String ANSI_YELLOW = "\u001B[33m";
String ANSI_BLUE = "\u001B[34m";
String ANSI_PURPLE = "\u001B[35m";
String ANSI_CYAN = "\u001B[36m";
String ANSI_WHITE = "\u001B[37m";

        //int l=3;
        //int w=4;
    System.out.println(ANSI_CYAN + """
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
        """);
        int l=3, w=4;
        System.out.println("The area of the rectangle with length " + l + " and width " + w + " is " + l*w);

    }
}
