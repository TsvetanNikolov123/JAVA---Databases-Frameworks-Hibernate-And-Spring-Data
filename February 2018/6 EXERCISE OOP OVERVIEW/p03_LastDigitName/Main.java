package p03_LastDigitName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer input = Integer.parseInt(reader.readLine());

        String lastDigitOfNumber = Number.englishNameOfLastDigit(input);

        System.out.println(lastDigitOfNumber);
    }
}
