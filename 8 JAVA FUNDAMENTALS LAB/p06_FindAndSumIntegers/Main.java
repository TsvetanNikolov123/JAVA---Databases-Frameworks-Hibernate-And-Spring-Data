package p06_FindAndSumIntegers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> input = Arrays.asList(reader.readLine().split("\\s+"));

        OptionalInt sum = input.stream()
                .filter(i -> !i.isEmpty())
                .filter(i -> isNumber(i))
                .mapToInt(i -> Integer.valueOf(i))
                .reduce((a, b) -> a + b);

        if (sum.isPresent()) {
            System.out.println(sum.getAsInt());
        } else {
            System.out.println("No match");
        }
    }

    private static boolean isNumber(String s) {
        boolean result = true;
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            result = false;
        }

        return result;
    }
}
