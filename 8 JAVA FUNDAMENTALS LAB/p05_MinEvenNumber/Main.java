package p05_MinEvenNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> input = Arrays.asList(reader.readLine().split("\\s+"));

        Optional<Double> min = input.stream()
                .filter(i -> !i.isEmpty())
                .map(Double::valueOf)
                .filter(i -> i % 2 == 0)
                .min(Double::compare);

        if (min.isPresent()) {
            System.out.println(min.get());
        } else {
            System.out.println("No match");
        }
    }
}
