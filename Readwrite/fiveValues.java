import java.io.*;
import static java.lang.System.*;

public class fiveValues {
    public static void main(String[] args) {
        double num1 = 0, num2 = 0, num3 = 0, num4 = 0, num5 = 0;

        try {
            // reads from the file called fiveValues.txt
            FileReader fr = new FileReader("fiveValues.txt");
            BufferedReader br = new BufferedReader(fr);

            // reads each of the 5 lines and converts them to doubles
            num1 = Double.parseDouble(br.readLine().trim());
            num2 = Double.parseDouble(br.readLine().trim());
            num3 = Double.parseDouble(br.readLine().trim());
            num4 = Double.parseDouble(br.readLine().trim());
            num5 = Double.parseDouble(br.readLine().trim());

            br.close();
        } catch (IOException e) {
            out.println("Error reading file!");
            return;
        }

        // calculates sum, product, and average
        double sum = num1 + num2 + num3 + num4 + num5;
        double product = num1 * num2 * num3 * num4 * num5;
        double average = sum / 5;

        try {
            // writes the results to fiveValuesOutput.txt
            FileWriter fw = new FileWriter("fiveValuesOutput.txt");
            PrintWriter pw = new PrintWriter(fw);

            pw.println("Sum: " + sum);
            pw.println("Product: " + product);
            pw.println("Average: " + average);

            pw.close();
            out.println("Results written to fiveValuesOutput.txt");
        } catch (IOException e) {
            out.println("Error writing file!");
        }
    }
}