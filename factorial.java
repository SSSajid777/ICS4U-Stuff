import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a integer to find its factorial");
        int factorial=scan.nextInt();
        for(int i=factorial-1; i>=1; i--){
            factorial=factorial*i;
        }
        System.out.println("The factorial is " + factorial);
         



    }
    
}
