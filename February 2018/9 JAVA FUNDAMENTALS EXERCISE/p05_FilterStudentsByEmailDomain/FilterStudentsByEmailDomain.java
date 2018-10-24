package p05_FilterStudentsByEmailDomain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FilterStudentsByEmailDomain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();

        String line;

        while (!"END".equals((line = reader.readLine()))) {
            String[] info = line.split("\\s+");
            String firstName = info[0];
            String lastName = info[1];
            String email = info[2];
            Student student = new Student(firstName,lastName,email);
            students.add(student);
        }

        students
                .stream()
                .filter(s-> s.getEmail().endsWith("@gmail.com"))
                .forEach(System.out::println);
    }
}





