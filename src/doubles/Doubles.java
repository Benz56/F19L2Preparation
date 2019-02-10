/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doubles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Doubles {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/doubles/doubles.txt"))) {
            List<Double> values = new ArrayList<>();
            while (scanner.hasNext()) {
                values.add(Double.parseDouble(scanner.next()));
            }

            Collections.sort(values);
            double sum = values.stream().mapToDouble(Double::doubleValue).sum();
            System.out.println("The sum of all doubles is: " + sum);
            System.out.println("The largest double value is: " + values.get(values.size() - 1));
            System.out.println("The smallest double value is: " + values.get(0));
            System.out.println("The average double value is: " + sum / values.size());
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        }
    }
}
