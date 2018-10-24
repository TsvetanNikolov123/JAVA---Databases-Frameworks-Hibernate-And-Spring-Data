package p07_AverageGrades;

import java.util.Arrays;

public class Student implements Comparable<Student>{
    private String name;
    private double[] grades;
    private double averageGrades;

    public Student(String name, double[] grades) {
        this.name = name;
        this.grades = grades;
        this.averageGrades = Arrays.stream(this.grades).average().orElse(0d);
    }

    public String getName() {
        return this.name;
    }

    public double[] getGrades() {
        return this.grades;
    }

    public double getAverageGrades() {
        return this.averageGrades ;
    }

    @Override
    public int compareTo(Student other) {
        int res = this.getName().compareTo(other.getName());
        if (res == 0) {
            res = Double.compare(other.getAverageGrades(), this.getAverageGrades());
        }
        return res;
    }

    @Override
    public String toString() {
        return String.format("%s -> %.2f",
                this.getName(),
                this.getAverageGrades());
    }
//    private void averageGrades(List<Double> grades) {
//        double sumOfGrades = 0;
//        int countOfGrades = grades.size();
//
//        for (Double grade : grades) {
//            sumOfGrades += grade;
//        }
//        double averageGrades = sumOfGrades / countOfGrades;
//        this.averageGrades = averageGrades;
//    }
}
