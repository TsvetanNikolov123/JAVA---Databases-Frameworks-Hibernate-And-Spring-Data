/*Create a program to check if given symbol is digit, vowel or any other symbol.*/

package p04_VowelOrDigit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char input = (char) reader.read();
        if (input == 'a' || input == 'e' || input == 'o' || input == 'i' || input == 'u' ) {
            System.out.println("vowel");
        } else if (Character.isDigit(input)) {
            System.out.println("digit");
        } else {
            System.out.println("other");
        }
    }
}
