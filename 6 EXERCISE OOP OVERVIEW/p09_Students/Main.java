package p09_Students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        while (!input.equals("End")) {
            new Student(input);

            input = reader.readLine();
        }

        int count = Student.studentsCount();
        System.out.println(count);
    }
}
