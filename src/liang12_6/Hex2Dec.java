/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liang12_6;

import java.util.Scanner;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Hex2Dec {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a hex number: ");

        String hex;
        while (!(hex = scanner.next()).equalsIgnoreCase("quit")) {
            try {
                System.out.println("The decimal value for hex number " + hex + " is " + hexToDecimal(hex.toUpperCase()));
            } catch (NumberFormatException e) {
                System.out.println("Input is not a hex number!");
            }
            System.out.print("Enter a hex number: ");
        }
    }

    public static int hexToDecimal(String hex) throws NumberFormatException {
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }
        return decimalValue;
    }

    private static int hexCharToDecimal(char ch) throws NumberFormatException {
        if (ch >= 'A' && ch <= 'F') {
            return 10 + ch - 'A';
        } else if (Character.isDigit(ch)) {
            return ch - '0';
        }
        throw new NumberFormatException();
    }
}
