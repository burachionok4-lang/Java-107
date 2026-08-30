package StrategyPattern;

import java.util.Comparator;
import java.util.List;

public class SortByAge implements SortStudentStrategy {
    @Override
    public void studentSort(List<Student> students) {
        if (students == null) return;

        students.sort(
                Comparator.nullsLast(
                        Comparator.comparing(
                                Student::getStudentAge,
                                Comparator.nullsLast(Integer::compareTo)
                        ).reversed()

                )
        );
    }
}
