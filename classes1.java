import java.util.Scanner;
public class classes1 extends classes2 {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.println("Please enter 3 numbers");
        int num1, num2, num3;
        num1=scan.nextInt();
        num2=scan.nextInt();
        num3 =scan.nextInt();
        calculate1(num1, num2, num3);
        calculate2(num1, num2, num3);
    }
}
