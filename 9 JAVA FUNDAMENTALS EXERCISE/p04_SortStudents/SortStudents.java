package p04_SortStudents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> fullNames = new LinkedList<>();

        String input = reader.readLine().trim();
        while (!input.equals("END")) {
            fullNames.add(input);
            input = reader.readLine();
        }
        fullNames.stream()
                .map(str -> str.split("\\s+"))
                .sorted(Comparator
                        .comparing((String[] x) -> x[1])
                        .thenComparing((x, y) -> y[0].compareTo(x[0])))
                .forEach(s -> System.out.printf("%s %s%n", s[0], s[1]));

    }
}
