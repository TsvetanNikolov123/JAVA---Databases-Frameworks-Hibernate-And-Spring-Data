package p07_BoundedNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] bounds = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int lowerBound = Math.min(bounds[0],bounds[1]);
        int upperBound = Math.max(bounds[0],bounds[1]);

        int[] numbers = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Arrays.stream(numbers)
                .filter(n -> n >= lowerBound && n <= upperBound)
                .forEach(n -> System.out.print(n + " "));
    }
}
