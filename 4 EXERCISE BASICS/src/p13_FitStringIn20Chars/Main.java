/*  Write a program that reads from the console a string and fits the string in 20 characters as follows:
    •	If the string has less than 20 characters, append some ‘*’ until it gets length of exactly 20 characters.
    •	If the string length is more than 20 characters, discard all characters after the first 20.
    Print the result string at the console.
*/

package p13_FitStringIn20Chars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        if (input.length() < 20) {
            String result = String.format("%s%s",
                    input,
                    new String(new char[20 - input.length()]).replaceAll("\0", "*"));
            System.out.println(result);
        } else if (input.length() > 20) {
            String result = input.substring(0,20);
            System.out.println(result);
        }
    }
}
