package p08_WeakStudents;

public class Student {
    private String firstName;
    private String lastName;
    private int[] grades;

    public Student() {
    }

    public Student(String firstName, String lastName, int... grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }

    public int[] getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
