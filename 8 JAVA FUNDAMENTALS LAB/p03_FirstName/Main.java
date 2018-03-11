package p03_FirstName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = Arrays.asList(reader.readLine().split("\\s+"));
        String comparator = reader.readLine();

        Optional<String> firstName = names.stream()
                .filter(n -> n.toLowerCase().startsWith(comparator.toLowerCase()))
                .sorted()
                .findFirst();

        if (firstName.isPresent()){
            System.out.println(firstName.get());
        } else  {
            System.out.println("No match");
        }
    }
}
