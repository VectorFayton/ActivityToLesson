package Problem_C;

import java.util.Scanner;
import java.io.*;

public class SimpleIO {
    public static void main(String[] args) throws IOException {
        // Ask for input file
        Scanner Input = new Scanner(System.in);
        String inputFile = "";
        File file;
        while (true) {
            System.out.print("Enter the name of the input file: ");
            inputFile = Input.nextLine();
            file = new File(inputFile);
            if (file.exists() && !file.isDirectory()) {
                break;
            }
            System.out.println("File not found, please enter a valid file name.");
        }

        // Ask for output file
        String outputFile = "";
        File output;
        while (true) {
            System.out.print("Enter the name of the output file: ");
            outputFile = Input.nextLine();
            output = new File(outputFile);
            if (output.exists() && !output.isDirectory()) {
                System.out.println("File already exists, please enter a new file name.");
            } else {
                break;
            }
        }

        // Read input file, count occurrences of "the", and write to output file
        Scanner input = new Scanner(file);
        PrintWriter outputWriter = new PrintWriter(output);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] words = line.toLowerCase().split(" ");
            int count = 0;
            for (String word : words) {
                if (word.equals("the")) {
                    count++;
                }
            }
            outputWriter.println(line + " [" + count + "]");
        }

        // Close files and finish program
        input.close();
        outputWriter.close();
        System.out.println("Done. Output written to " + outputFile);
    }
}
