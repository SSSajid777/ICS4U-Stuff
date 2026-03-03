import java.util.Scanner;

public class whileloops {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /*
         * int counter = 1;
         * 
         * while (counter < 11) {
         * System.out.print(counter + " ");
         * counter += 1; // or you could write counter++ or counter=counter + 1
         * 
         * }
         * int counter1 = 10;
         * while (counter1 > 0) {
         * System.out.print(counter1 + " ");
         * counter1 -= 1; // or you could write counter-- or counter=counter - 1
         * 
         * }
         * 
         * int num=1;
         * while(num !=-1){
         * System.out.println("Input any number. Enter -1 to exit");
         * num = scan.nextInt();
         * 
         * 
         * }
         * 
         * 
         * //this is an infinite loop
         * while (true) {
         * System.out.println("Input any number. Enter -1 to exit");
         * int num1 = scan.nextInt();
         * if(num1 ==-1){
         * break; //breaks the loops it is currently in
         * }
         * }
         */
        boolean decision = true;
        while (decision) {
            System.out.println("Input any number. Enter -1 to exit");
            int num1 = scan.nextInt();
            if (num1 == -1) {
                break; // breaks the loops it is currently in

            }

        }

    }

}