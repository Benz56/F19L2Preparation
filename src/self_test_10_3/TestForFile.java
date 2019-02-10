/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package self_test_10_3;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class TestForFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type the name of the file to check existence for: ");

        File file = new File("src/" + scanner.nextLine());

        if (file.exists()) {
            System.out.println("The file exists. Do you wish to delete it? (y/n)");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("y")) {
                System.out.println(file.delete() ? "The file has been deleted!" : "Unable to delete file.");
            } else if (answer.equalsIgnoreCase("n")) {
                System.out.println("Alright. Exiting.");
            } else {
                System.out.println("Invalid answer.");
            }
        } else {
            System.out.println("The file does not exist!");
        }
    }
}
