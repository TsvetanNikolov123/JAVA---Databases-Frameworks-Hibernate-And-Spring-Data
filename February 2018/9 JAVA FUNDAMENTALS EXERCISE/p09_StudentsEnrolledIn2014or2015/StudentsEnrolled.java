package p09_StudentsEnrolledIn2014or2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudentsEnrolled {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer[]> students = new LinkedHashMap<>();
        String line;

        while (!"END".equals(line = reader.readLine())) {
            String[] info = line.split("\\s+");
            String facultyNumber = info[0];
            Integer[] grades = Arrays
                    .stream(info)
                    .skip(1L)
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            students.putIfAbsent(facultyNumber, grades);
        }

//        Integer[] asd = new Integer[]{1,2,3};
//        String[] asd2 = Arrays.stream(asd).map(String::valueOf).toArray(String[]::new);

        students
                .entrySet()
                .stream()
                .filter(s -> s.getKey().endsWith("14") || s.getKey().endsWith("15"))
                .map(Map.Entry::getValue)
                .map(arr -> Arrays.stream(arr).map(String::valueOf).toArray(String[]::new))
                .forEach(a -> System.out.println(
                        String.join(" ", a)
                ));
    }
}
