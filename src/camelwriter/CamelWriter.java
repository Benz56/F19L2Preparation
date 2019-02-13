/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camelwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class CamelWriter {

    private final File inFile;

    public CamelWriter(String fileName) {
        inFile = new File(fileName);
    }

    public void readLines() {
        try (Scanner scanner = new Scanner(inFile)) {
            while (scanner.hasNextLine()) {
                convert2camel(scanner.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }

    private void convert2camel(String line) {
        String[] split = line.trim().split(" ");
        for (int i = 0; i < split.length; i++) {
            split[i] = (i == 0 ? split[i].toLowerCase() : split[i].substring(0, 1).toUpperCase()) + (i > 0 ? split[i].substring(1).toLowerCase() : "");
        }
        System.out.println(String.join("", split));
    }

    public static void main(String[] args) {
        new CamelWriter("src/camelwriter/DryLips.txt").readLines();
        System.out.println("\n\n----------------------------------\n\n");
        new CamelWriter("src/camelwriter/MaryAnn.txt").readLines();
        System.out.println("\n\n----------------------------------\n\n");
        new CamelWriter("src/camelwriter/OhLand.txt").readLines();
    }
}
