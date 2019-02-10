/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danish_islands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author erso
 */
public class DanishIslandFileReader {

    private final File inFile;
    private List<DanishIsland> islandList;

    public DanishIslandFileReader(String fName) {
        inFile = new File(fName);
    }

    private void readFile() {
        islandList = new ArrayList<>();
        try (Scanner scanner = new Scanner(inFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(" ");
                String name = tokens[0];
                double circ = Double.parseDouble(tokens[1]);
                double area = Double.parseDouble(tokens[2]);
                int addr = Integer.parseInt(tokens[3]);
                int adkm = Integer.parseInt(tokens[4]);
                islandList.add(new DanishIsland(name, circ, area, addr, adkm));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        } catch (NumberFormatException ex) {
            System.out.println("Something went wrong when parsing a value!");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("A line is missing information!");
        }
    }

    public List<DanishIsland> getList() {
        return islandList;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DanishIslandFileReader fr = new DanishIslandFileReader("src/danish_islands/Islands punktum.txt");
        //DanishIslandFileReader fr = new DanishIslandFileReader("src/danish_islands/Islands komma.txt");
        fr.readFile();

        System.out.println("Result:\n" + fr.getList());
    }
}
