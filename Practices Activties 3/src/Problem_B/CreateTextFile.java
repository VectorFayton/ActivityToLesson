package Problem_B;
import java.io.*;
import java.util.Scanner;


public class CreateTextFile {
    public static String[] readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        String[] lines = new String[1000];
        int lineCounter = 0;

        Scanner Input = new Scanner(file);
        String line = null;

        while (Input.hasNextLine()){
            line = Input.nextLine();
            lines[lineCounter] = line;
            lineCounter++;
        }



        return  lines;
    }

    public static void main(String[] args) {
        String filename = "Text.txt";
        String[] Write_lines = {
                "Purple Rain by Prince",
                "I never meant to cause you any sorrow",
                "I never meant to cause you any pain",
                "I only wanted one time to see you laughing",
                "I only want to see you laughing in the purple rain"
        };

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (String line : Write_lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try{
            String[] Read_lines = readFile(filename);
            int i = 0;
            for (String line: Read_lines)
            {
                if (line == null)
                    break;

                System.out.println(String.format("[%s]: %s", i, line));
                i++;
            }
        } catch (FileNotFoundException exc){
            System.out.println(exc.getMessage());
        }
        System.out.println("File \"" + filename + "\" created successfully.");
    }
}