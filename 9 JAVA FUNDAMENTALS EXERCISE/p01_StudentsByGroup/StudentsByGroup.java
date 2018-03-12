package p01_StudentsByGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class StudentsByGroup {
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
                .filter(fullName -> fullName[2].equals("2"))
                .sorted(Comparator.comparing(s -> s[0]))
                .forEach(fullName -> System.out.printf("%s %s%n", fullName[0], fullName[1]));
    }
}
