/*  Write a program that creates an array containing all letters from the alphabet (a-z). Read a lowercase word from
 *  the console and print the index of each of its letters in the letters array.
 */

package p10_IndexOfLetters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] charArr = reader.readLine().toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            char currentChar = charArr[i];
            int indexOfCharInArr = charArr[i] - 97;

            System.out.printf("%c -> %d%n", currentChar, indexOfCharInArr);
        }
    }
}
