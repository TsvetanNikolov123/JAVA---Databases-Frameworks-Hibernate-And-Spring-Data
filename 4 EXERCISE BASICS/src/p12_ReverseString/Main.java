/*  Write a program that reads a string from the console, reverses its
 *  letters and prints the result back at the console.*/

package p12_ReverseString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] charArr = reader.readLine().toCharArray();

        for (int i = charArr.length - 1; i >= 0; i--) {
            System.out.print(charArr[i]);
        }
    }
}
