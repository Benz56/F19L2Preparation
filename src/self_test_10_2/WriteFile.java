/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package self_test_10_2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class WriteFile {

    public static void main(String[] args) {
        System.out.print("Enter the name of the file to write to: ");

        try (Scanner scanner = new Scanner(System.in); PrintWriter outStream = new PrintWriter(new FileOutputStream("src/self_test_10_2/" + scanner.nextLine() + ".txt", true))) {
            System.out.print("Type 'quit' or the next line in the file: ");
            String line;
            while (!(line = scanner.nextLine()).equalsIgnoreCase("quit")) {
                outStream.println(line);
                System.out.print("Type 'quit' or the next line in the file: ");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found or is a directory!");
        }
    }
}
