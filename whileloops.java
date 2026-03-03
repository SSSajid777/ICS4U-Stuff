import java.util.Scanner;

public class whileloops {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int counter = 1;

        while (counter < 11) {
            System.out.print(counter + " ");
            counter += 1; // or you could write counter++ or counter=counter + 1

        }
        int counter1 = 10;
        while (counter1 > 0) {
            System.out.print(counter1 + " ");
            counter -= 1; // or you could write counter-- or counter=counter - 1

        }
    }
}