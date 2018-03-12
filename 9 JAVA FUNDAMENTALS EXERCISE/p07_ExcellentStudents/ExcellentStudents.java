package p07_ExcellentStudents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcellentStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();

        String line;

        while (!"END".equals((line = reader.readLine()))) {
            String[] info = line.split("\\s+");
            String firstName = info[0];
            String lastName = info[1];
            int[] grades = Arrays
                    .stream(info)
                    .skip(2L)
                    .mapToInt(Integer::valueOf)
                    .toArray();

            Student student = new Student(firstName, lastName, grades);
            students.add(student);
        }

        students
                .stream()
                .filter(s -> Arrays.stream(s.getGrades()).anyMatch(g -> g == 6))
                .forEach(System.out::println);
    }
}
