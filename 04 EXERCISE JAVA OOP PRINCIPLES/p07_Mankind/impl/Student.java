package p07_Mankind.impl;

public class Student extends Human{
    private  static final String INVALID_FACULTY_NUMBER_LENGTH_EXCEPTION_MESSAGE = "Invalid faculty number!";

    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private void setFacultyNumber(String facultyNumber){
        if (facultyNumber.length() < 5 || facultyNumber.length() > 10){
            throw new IllegalArgumentException(INVALID_FACULTY_NUMBER_LENGTH_EXCEPTION_MESSAGE);
        }

        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString())
                .append("Faculty number: ").append(this.facultyNumber).append(System.lineSeparator());

        return sb.toString();
    }
}
