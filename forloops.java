import java.util.Scanner;

public class forloops{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /* 
        //i=i+1 or i++ or i+=1
        for(int i = 1; i<6; i++){
            System.out.println(i+" ");
            */


            /*
        for(int i = 1; i<6; i++){
            System.out.print(i +" * 6 = " + (i*6) +"      ");
            
        System.out.println("Enter the number you want the times table for.");
        int multiplier = scan.nextInt();
        for(int i = 1; i<6; i++){
            System.out.println(i +" * " + multiplier + " = " + (i*multiplier));
            */
        for (int i = 10; i > 0; i--){
            System.out.println(i);
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){
                
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
 

        }
    }
