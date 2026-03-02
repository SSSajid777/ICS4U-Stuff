import java.util.Scanner;
public class homework3{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a positive integer"); //1. Asks the user to enter a positive integer n.
        int number=scan.nextInt();
        int sum=0;
        for(int i=1; i<=number; i++){
            if(i%2==0){
                sum+=i;
            }
        }
        System.out.println("The sum of all even numbers from 1 to "+ number +" is " + sum);


        System.out.println("Enter a word to count how many vowels in a word");
        int sum_vowel= 0;
        String word=scan.next();
        for(int i=0; i<word.length(); i++){ //how do i make it work for both uppercase and lowercase letters?
            if(word.toLowerCase().charAt(i)=='a'||word.toLowerCase().charAt(i)=='e'||word.toLowerCase().charAt(i)=='i'||word.toLowerCase().charAt(i)=='o'||word.toLowerCase().charAt(i)=='u'){
                sum_vowel+=1;
            }


        
        }
        System.out.println("The number of vowels in the word "+word+" is "+sum_vowel);


        System.out.print("Enter a positive interger to output that number of stars"); //how do i Uses a for loop to print a growing triangle pattern of stars, where the first line has 1 star, the second line has 2 stars, and so on, until the nth line has n stars.
        int user_stars= scan.nextInt();
        for(int i=0; i<user_stars; i++){
            for(int j=0; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}