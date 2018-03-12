package p03_StudentsByAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class StudentsByAge {
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
                .filter(s -> Integer.valueOf(s[2]) >= 18 && Integer.valueOf(s[2]) <= 24)
                .forEach(fullName -> System.out.printf("%s %s %s%n", fullName[0], fullName[1], fullName[2]));
    }
}