package StrategyPattern;

import java.util.Objects;

public class Student {
    private String studentName;
    private double studentScore;
    private int studentAge;
    public Student(String studentName, double studentScore, int studentAge) {
        this.studentName = studentName;
        this.studentScore = studentScore;
        this.studentAge = studentAge;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentScore(double studentScore) {
        this.studentScore = studentScore;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getStudentScore() {
        return studentScore;
    }

    public int getStudentAge() {
        return studentAge;
    }
    @Override
    public String toString() {
        return String.format("%s (age=%d, score=%.2f)", studentName, studentAge, studentScore);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student that = (Student) o;
        return studentAge == that.studentAge
                && studentScore == that.studentScore
                && Objects.equals(studentName,that.studentName);
    }
    @Override
    public  int hashCode(){
        return Objects.hash(studentName,studentScore,studentAge);
    }
}
