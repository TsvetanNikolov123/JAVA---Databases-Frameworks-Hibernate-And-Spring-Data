package p06_FilterStudentsByPhone;

public class Student {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Student() {
    }

    public Student(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}