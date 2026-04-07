import java.util.Scanner;
public class classes3 {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.println("Please enter 3 numbers");
        int num1, num2, num3;
        num1=scan.nextInt();
        num2=scan.nextInt();
        num3 =scan.nextInt();
        classes2 x = new classes2();
        x.calculate1(num1, num2, num3);
        x.calculate2(num1, num2, num3);
    }
}
