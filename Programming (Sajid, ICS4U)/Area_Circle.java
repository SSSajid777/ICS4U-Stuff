import java.util.Scanner;
public class Area_Circle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("What is your name?");
        String user_name = scan.next();

        double pi=3.14;

        System.out.println("Enter your radius (as integer)");
        int user_radius = scan.nextInt();

        double Area = (pi*(user_radius*user_radius));
        System.out.println("The Area is " + Area);

        double Perimenter = (2*pi*user_radius);
        System.out.println("The Perimeter is " + Perimenter);




        

    }
}
