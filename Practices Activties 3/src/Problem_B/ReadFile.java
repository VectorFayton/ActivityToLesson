package Problem_B;
//        String plafornIndependent = "test-dir" + File.separator + "Text.txt"; // best solution
//        String filePath = "D:\\Файлопомойка\\Работа\\ActivityToLesson\\Practices Activties 3\\src\\Problem_B\\Text";
import java.util.*;
import java.io.*;


public class ReadFile {
    public static String[] readFile(String fileName) throws FileNotFoundException{
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
    public static void main(String[] args) throws FileNotFoundException{
        String filename = "Text.txt";
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
    }
}
