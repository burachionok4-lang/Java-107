package StrategyPattern;

import java.util.Comparator;
import java.util.List;

public class SortByScore implements SortStudentStrategy {
    @Override
    public void studentSort(List<Student> students) {
        if (students == null) return;

        students.sort(
                Comparator.nullsLast(
                        Comparator.comparing(
                                Student::getStudentScore,
                                Comparator.nullsLast(Double::compareTo)
                        ).reversed()

                )
        );
    }
}
