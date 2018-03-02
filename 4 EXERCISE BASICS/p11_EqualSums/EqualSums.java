/*  Write a program that determines if there exists an element in the array such that the sum of the elements
 *  on its left is equal to the sum of the elements on its right. If there are no elements to the left / right,
 *  their sum is considered to be 0. Print the index that satisfies the required condition or “no” if there is
 *  no such index.*/

// 100/100 in Judge !!!

package p11_EqualSums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EqualSums {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        int[] inputArr = new int[input.length];

        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = Integer.parseInt(input[i]);
        }

        Boolean foundNum = false;

        for (int i = 0; i < inputArr.length; i++)
        {
            long leftSum = 0L;
            long rightSum = 0L;

            for (int j = 0; j < i; j++)
            {
                leftSum += inputArr[j];
            }

            for (int k = i + 1; k < inputArr.length; k++)
            {
                rightSum += inputArr[k];
            }

            if (leftSum == rightSum)
            {
                System.out.println(i);
                foundNum = true;
            }
        }

        if (!foundNum)
        {
            System.out.println("no");
        }
    }
}
