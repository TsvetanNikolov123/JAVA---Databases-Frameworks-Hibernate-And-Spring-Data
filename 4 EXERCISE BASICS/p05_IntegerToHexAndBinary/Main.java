/*Create a program to convert a decimal number to hexadecimal and binary number and print it.*/

package p05_IntegerToHexAndBinary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer input =Integer.parseInt(reader.readLine());

        String hex = Integer.toHexString(input).toUpperCase();
        String binary = Integer.toBinaryString(input);

        System.out.println(hex);
        System.out.println(binary);
    }
}
