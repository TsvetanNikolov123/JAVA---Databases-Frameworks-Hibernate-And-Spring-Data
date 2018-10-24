package p06_FilterStudentsByPhone;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.List;

public class FilterStudentsByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();

        String line;

        while (!"END".equals((line = reader.readLine()))) {
            String[] info = line.split("\\s+");
            String firstName = info[0];
            String lastName = info[1];
            String phoneNumber = info[2];
            Student student = new Student(firstName, lastName, phoneNumber);
            students.add(student);
        }

        students
                .stream()
                .filter(s -> s.getPhoneNumber().startsWith("02") ||
                        s.getPhoneNumber().startsWith("+3592"))
                .forEach(System.out::println);
    }
}

