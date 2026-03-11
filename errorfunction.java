import java.util.Scanner;
public class errorfunction{
    public static int word1; //this is a global variable that can be used in any function
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int min = 1;
        int max = 3;
        menu();
        System.out.println("Enter a choice");
        String choice = scan.next();
        error1(choice, min, max);
        System.out.println("You chose " + word1 + ", yay!");

    }
    public static void menu(){
        System.out.println("""
            Menu
            1.) item 1
            2.) item 2
            3) item 3
        
                """);
    }
    public static void timer(){
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
    }
    public static void error1(String word, int min1, int max1){
        Scanner scan = new Scanner(System.in);
        while (true) { 
            try {
                word1 = Integer.parseInt(word);
                if (word1 < min1 || word1 > max1){
                    System.out.println("Enter between " + min1 + " and " + max1);
                    timer();
                    System.out.println("\003[H\033[2J");
                    menu();
                    word = scan.next();
                }
                else{
                    break;
                }
            } catch (Exception e) {
                System.out.println("Enter an integer only!");
                timer();
                System.out.println("\003[H\033[2J");
                menu();
                word = scan.next();

            }
        }

    }
}