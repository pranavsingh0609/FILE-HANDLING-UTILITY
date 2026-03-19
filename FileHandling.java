import java.io.*;
import java.util.Scanner;

public class FileHandling {

    public static void writeFile(String fileName, String content) {
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(content);
            fw.close();
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }

    public static void readFile(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            System.out.println("\nFile Content:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    public static void modifyFile(String fileName, String newContent) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            fw.write("\n" + newContent);
            fw.close();
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "sample.txt";

        System.out.print("Enter text to write: ");
        String text = sc.nextLine();
        writeFile(fileName, text);

        readFile(fileName);

        System.out.print("\nEnter text to append: ");
        String newText = sc.nextLine();
        modifyFile(fileName, newText);

        readFile(fileName);

        sc.close();
    }
}