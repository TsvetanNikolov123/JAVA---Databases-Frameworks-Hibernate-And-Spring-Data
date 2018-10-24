/*  Write a program that reads a string, converts it to Boolean variable and prints “Yes” if the variable is true
 *  and “No” if the variable is false.*/

package p02_BooleanVariable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        boolean isTrue = input.equals("True");
        if (isTrue) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
