package p04_AverageOfDoubles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> input = Arrays.asList(reader.readLine().split("\\s+"));

        OptionalDouble avg = input.stream()
                .filter(s-> !s.isEmpty())  // това ее ако подадеме празен стринг!!!
                .mapToDouble(s -> Double.parseDouble(s))
                .average();

        if (avg.isPresent()) {
            System.out.println(avg.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
