package p07_AverageGrades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Student> students = new ArrayList<>();
        int studentCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < studentCount; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String studentName = tokens[0];
            double[] grades = new double[tokens.length - 1];

            for (int j = 1; j < tokens.length; j++) {
                grades[j - 1] = Double.parseDouble(tokens[j]);
            }

            students.add(new Student(studentName, grades));
        }

        StringBuilder sb = new StringBuilder();

        students.stream()
                .filter(student -> student.getAverageGrades() >= 5.00)
                .sorted()
                .forEach(student -> sb.append(student.toString()).append(System.lineSeparator()));


        System.out.println(sb.toString());
    }
}
