import java.util.Scanner;
public class avg1_homework9 extends avg2_homework9  {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.println("Please enter 4 numbers");
        int num1, num2, num3, num4;
        num1=scan.nextInt();
        num2=scan.nextInt();
        num3 =scan.nextInt();
        num4 = scan.nextInt();
        average1(num1, num2, num3, num4);
        
    }
}
