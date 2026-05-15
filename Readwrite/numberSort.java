import java.util.Scanner;
import java.io.*;
import static java.lang.System.*;

public class numberSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = new int[10];

        // asks user to input 10 numbers
        out.println("Please enter 10 numbers:");
        for (int i = 0; i < 10; i++) {
            out.print("Number " + (i + 1) + ": ");
            numbers[i] = scan.nextInt();
        }

        try {
            // writes the unsorted numbers to numberSort.txt
            FileWriter fw = new FileWriter("numberSort.txt");
            PrintWriter pw = new PrintWriter(fw);

            for (int i = 0; i < 10; i++) {
                pw.println(numbers[i]);
            }
            pw.close();
        } catch (IOException e) {
            out.println("Error writing file!");
            return;
        }

        // reads the numbers back from numberSort.txt
        int[] readNumbers = new int[10];
        try {
            FileReader fr = new FileReader("numberSort.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            int index = 0;

            while ((line = br.readLine()) != null) {
                readNumbers[index] = Integer.parseInt(line.trim());
                index++;
            }
            br.close();
        } catch (IOException e) {
            out.println("Error reading file!");
            return;
        }

        // sorts the numbers in ascending order using a bubble sort
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9 - i; j++) {
                if (readNumbers[j] > readNumbers[j + 1]) {
                    int temp = readNumbers[j];
                    readNumbers[j] = readNumbers[j + 1];
                    readNumbers[j + 1] = temp;
                }
            }
        }

        try {
            // writes the sorted numbers to numberSortOutput.txt
            FileWriter fw = new FileWriter("numberSortOutput.txt");
            PrintWriter pw = new PrintWriter(fw);

            for (int i = 0; i < 10; i++) {
                pw.println(readNumbers[i]);
            }
            pw.close();
            out.println("Sorted numbers written to numberSortOutput.txt");
        } catch (IOException e) {
            out.println("Error writing file!");
        }
    }
}