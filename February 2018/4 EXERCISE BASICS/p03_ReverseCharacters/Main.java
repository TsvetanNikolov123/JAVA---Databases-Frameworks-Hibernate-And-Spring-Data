/*Write a program to ask the user for 3 letters and print them in reversed order*/

package p03_ReverseCharacters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstLetter = reader.readLine();
        String secondLetter = reader.readLine();
        String thirdLetter = reader.readLine();

        System.out.printf("%s%s%s", thirdLetter, secondLetter, firstLetter);
    }
}
