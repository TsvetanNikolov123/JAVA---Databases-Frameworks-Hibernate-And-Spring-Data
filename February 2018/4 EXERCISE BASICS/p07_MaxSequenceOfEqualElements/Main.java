/*  Write a program that finds the longest sequence of equal elements in an array of integers.
 *  If several longest sequences exist, print the leftmost one.
 */

package p07_MaxSequenceOfEqualElements;

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

        int bestCount = 1;
        int tempCount = 1;
        int bestNum = 0;

        for (int i = 0; i < intArr.length - 1; i++) {
            if (intArr[i] == intArr[i + 1]) {
                tempCount++;
            } else {
                tempCount = 1;
            }
            if (tempCount > bestCount) {
                bestCount = tempCount;
                bestNum = intArr[i];
            }
        }

        for (int i = 0; i < bestCount; i++) {
            System.out.print(bestNum + " ");
        }
        System.out.println();
    }
}
