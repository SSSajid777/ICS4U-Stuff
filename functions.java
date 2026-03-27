import java.util.Scanner;

public class functions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //this calls the method greeting
        greeting();
         //this calls the method greeting1 with 1 parameter
        greeting1("Jello");
        System.out.print("Enther a length: ");
        int l1=scan.nextInt();
        System.out.print("Enter a width: ");
        int w1=scan.nextInt();
         //this calls the method rectArea with 2 parameters
        rectArea(l1, w1);

    }
    //This is a method that does not pass a parameter or variable in the empty brackets
    public static void greeting(){
        System.out.println("Hello");

    }
    //This is a method that takes 1 parameter or variable in the brackets
    //the variable is local to the method
    public static void greeting1(String word){
        System.out.println("Hello " + word);


    }
    public static void rectArea(int l, int w){
        System.out.println("Given the length " + l + " and the width " + w + " the area is " + (l*w));
    }
    
}
