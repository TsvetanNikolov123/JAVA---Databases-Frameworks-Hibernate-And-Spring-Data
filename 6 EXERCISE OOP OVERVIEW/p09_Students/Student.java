package p09_Students;

public class Student {
    private String name;
    private static int count = 0;

    public Student(String name) {
        this.name = name;
        count++;
    }

    public static int studentsCount(){
        return count;
    }
}
