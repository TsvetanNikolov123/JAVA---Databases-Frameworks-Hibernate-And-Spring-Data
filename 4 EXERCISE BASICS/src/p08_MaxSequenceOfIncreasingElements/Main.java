/*  Write a program that finds the longest increasing subsequence in an array of integers. The longest increasing
 *  subsequence is a portion of the array (subsequence) that is strongly increasing and has the longest possible length.
 *  If several such subsequences exist, find the left most of them.
 */

package p08_MaxSequenceOfIncreasingElements;

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

        int maxStart = 0;
        int maxLen = 1;
        int currentStart = 0;
        int currentLen = 1;

        for (int i = 1; i < intArr.length; i++) {
            if (intArr[i] > intArr[i - 1]) {
                currentLen++;
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                    maxStart = currentStart;
                }
            } else {
                currentStart = i;
                currentLen = 1;
            }
        }

        for (int i = maxStart; i < maxStart + maxLen; i++) {
            System.out.printf("%d ", intArr[i]);
        }
    }
}
