/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package self_test_10_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class ReadFile {

    public static void main(String[] args) {
        System.out.print("Input the name of the file to read: ");

        try (Scanner scanner = new Scanner(System.in); Scanner inputStream = new Scanner(new File("src/self_test_10_2/" + scanner.nextLine() + ".txt"))) {
            scanner.close();
            while (inputStream.hasNextLine()) {
                System.out.println(inputStream.nextLine());
            }
            inputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found or is a directory!");
        }
    }
}
