package p02_StudentsByFirstAndLastName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class StudentsByFirstAndLastName {
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
                .filter(f -> f[0].compareTo(f[1]) < 0)
                .forEach(fullName -> System.out.printf("%s %s%n", fullName[0], fullName[1]));
    }
}
