package javaPracticeProject.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileReadWriteSample {

    public static void main(String[] args) {
        File inFile = new File("src/package1/audiModels.txt");
        File outFile = new File("src/package1/audiModels2021.txt");

        try {
            Scanner input = new Scanner(inFile);
            PrintWriter output = new PrintWriter(outFile);
            while (input.hasNextLine()) {
                String model = input.nextLine() + " 2021";
                output.println(model);
            }
            input.close();
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
