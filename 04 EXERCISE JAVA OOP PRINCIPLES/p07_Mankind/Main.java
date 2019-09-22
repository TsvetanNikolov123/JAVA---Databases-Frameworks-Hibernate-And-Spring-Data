package p07_Mankind;

import p07_Mankind.impl.Human;
import p07_Mankind.impl.Student;
import p07_Mankind.impl.Worker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] studentInputLine = reader.readLine().split("\\s+");
        String[] workerInputLine = reader.readLine().split("\\s+");

        try {
            Human student = new Student(studentInputLine[0],studentInputLine[1],studentInputLine[2]);
            Human worker = new Worker(workerInputLine[0], workerInputLine[1],Double.parseDouble(workerInputLine[2]),
                    Double.parseDouble(workerInputLine[3]));

            System.out.println(student);
            System.out.println(worker);

        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

    }
}
