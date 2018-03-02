/*  Compare two char arrays lexicographically (letter by letter).
 *  Print the them in alphabetical order, each on separate line.
 */
package p06_CompareCharArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] firstArray = reader.readLine().replaceAll("\\s+", "").toCharArray();
        char[] secondArray = reader.readLine().replaceAll("\\s+", "").toCharArray();

        if (firstArray.length == secondArray.length) {
            if (firstArray[0] < secondArray[0]) {
                System.out.println(firstArray);
                System.out.println(secondArray);
            } else {
                System.out.println(secondArray);
                System.out.println(firstArray);
            }
        } else if (firstArray.length > secondArray.length) {
            System.out.println(secondArray);
            System.out.println(firstArray);
        } else {
            System.out.println(firstArray);
            System.out.println(secondArray);
        }
    }
}
