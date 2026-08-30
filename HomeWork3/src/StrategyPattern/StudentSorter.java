package StrategyPattern;

import java.util.List;

public class StudentSorter {
    SortStudentStrategy strategy;
public StudentSorter(SortStudentStrategy strategy){
    this.strategy = strategy;
}
    public void setStrategy(SortStudentStrategy strategy) {
        this.strategy = strategy;
    }
    public void sortStudents(List<Student> students) {
        strategy.studentSort(students);
    }
}
