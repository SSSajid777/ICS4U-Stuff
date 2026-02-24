
import java.util.Scanner;

public class test4 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //we are looking at functions involving strings
         String name1 = "ApplePie";
         System.out.println(name1.length()); //returns the length of the string

         System.out.println(name1.toUpperCase()); //returns the string to all uppercase
         System.out.println(name1.toLowerCase()); //returns the string to all lowercase

         //gets rid of the spaces before and after and makes the input lowercase
         String name2 = "    Hello    ".strip();
         System.out.println(name2);
         String name3 = scan.nextLine().strip().toLowerCase();
         System.out.println(name3.isEmpty());



         
         



    }
}