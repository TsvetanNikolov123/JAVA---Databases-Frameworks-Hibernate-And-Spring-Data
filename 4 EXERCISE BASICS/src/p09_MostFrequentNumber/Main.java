/*  Write a program that finds the most frequent number in a given sequence of numbers.
 *   •	Numbers will be in the range [0…65535].
 *   •	In case of multiple numbers with the same maximal frequency, print the left most of them.
 */

package p09_MostFrequentNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] strArr = reader.readLine().trim().split(" ");

        int[] intArr = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }

        if (intArr.length == 1) {
            System.out.println(intArr[0]);
            return;
        }
        int num = 0;
        int maxCount = 0;
        int tempCount = 1;

        for (int i = 0; i < intArr.length - 1; i++) {
            for (int j = i + 1; j < intArr.length; j++) {
                if (intArr[i] == intArr[j]) {
                    tempCount++;
                }
            }

            if (tempCount > maxCount) {
                maxCount = tempCount;
                num = intArr[i];
            }
            tempCount = 1;
        }
        System.out.println(num);
    }
}
