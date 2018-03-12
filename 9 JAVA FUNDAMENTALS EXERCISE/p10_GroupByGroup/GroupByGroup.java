package p10_GroupByGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> personList = new ArrayList<>();

        String line;

        while (!"END".equals(line = reader.readLine())) {
            String[] info = line.split("\\s+");
            personList
                    .add(new Person(info[0] + " " + info[1], Integer.parseInt(info[2])));
        }

        Stream<Person> personStream = personList.stream();
        personStream
                .collect(Collectors.groupingBy(Person::getGroup))
                .forEach((key, value) -> {
                    String personNames = value
                            .stream()
                            .map(Person::getName)
                            .collect(Collectors.joining(", "));
                    String result = String.format("%d - %s", key, personNames);
                    System.out.println(result);
                });
    }
}
