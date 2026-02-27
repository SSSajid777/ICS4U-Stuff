import java.util.Scanner;

public class forloops {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /*
         * //i=i+1 or i++ or i+=1
         * for(int i = 1; i<6; i++){
         * System.out.println(i+" ");
         */

        /*
         * for(int i = 1; i<6; i++){
         * System.out.print(i +" * 6 = " + (i*6) +"      ");
         * 
         * System.out.println("Enter the number you want the times table for.");
         * int multiplier = scan.nextInt();
         * for(int i = 1; i<6; i++){
         * System.out.println(i +" * " + multiplier + " = " + (i*multiplier));
         * 
         * for (int i = 10; i > 0; i--){
         * System.out.println(i);
         * delayclear();
         */
        /*
        int total = 0;
        System.out.println("Enter how many grades you want to average");
        int get_amount = scan.nextInt();
        for (int i = 1; i <= get_amount; i++) {
            System.out.println("Enter grade " + i + ": ");         
            double grade = scan.nextDouble();
            total += grade;
        }
        System.out.println("The average of " + get_amount + " numbers is " + (total / get_amount));
        */
        /*
        int counter=0;
        System.out.println("Enter a word");
        String word = scan.next();
        for (int i=0; i <word.length(); i++){
            if(word.charAt(i)=='a'||word.charAt(i)=='s'){
                counter+=1;
            }
        }
        System.out.println(word + " has the letter a and s"+ counter +" times");
        */
        for (int i=1; i <4; i++){
            System.out.println(i+ " ");//prints the row number
            for(int j=1; j<5; i++){
                System.out.print(j);//prints the column number
            }
            System.out.println();//goes to the next row

        }

    }

    public static void delayclear() {
        // a delay by 1 second so 1000 ms = 1 s
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        System.out.print("\033[H\033[2J"); // clear screen
        System.out.flush();

    }
}
