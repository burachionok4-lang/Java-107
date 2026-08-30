package StrategyPattern;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Nikita",99,23),
                new Student("Alice", 20.6, 21),
                new Student("Bob", 40.7, 25),
                new Student("Diana", 80.1, 22),
                new Student("Maria", 100, 21)
        );
        System.out.println("Сортировка по возрасту");
        StudentSorter sorter = new StudentSorter(new SortByAge());
        sorter.sortStudents(students);
        System.out.println(students);

        System.out.println("Сортировка по имени");
        sorter.setStrategy(new SortByName());
        sorter.sortStudents(students);
        System.out.println(students);

        System.out.println("Сортировка по оценкам");
        sorter.setStrategy(new SortByScore());
        sorter.sortStudents(students);
        System.out.println(students);
    }
}