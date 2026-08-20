import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        File jsonStudent = new File("src/students.json");
        List<Student> students = new ArrayList<>();
        try {
            students = mapper.readValue(jsonStudent, new TypeReference<List<Student>>() {});
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
        Optional<Integer> sortedBooks = students.stream()
                .filter(Objects::nonNull)
                .peek(System.out::println)                          // 1. Вывод студента
                .peek(student -> System.out.println(student.getStudentBook())) // 2. Список книг
                .flatMap(student -> student.getStudentBook().stream()) // 3. Получение книг
                .filter(Objects::nonNull)
                .distinct()                                         // 4. Уникальные книги
                .peek(book -> System.out.println(book.getBookName())) // 5. Названия книг
                .filter(book -> book.getReleaseDate() != null
                        && book.getReleaseDate().getYear() >= 2000) // 7. Фильтр после 2000
                .sorted(Comparator.comparingInt(Book::getPageCount)) // 8. Сортировка по страницам
                .limit(3)                                    // 9. Ограничение 3
                .map(Book::getReleaseDate)                          // 10. Получить даты
                .map(LocalDate::getYear)                            // 8. Преобразовать в год
                .findFirst();                                       // 9. Короткое замыкание -> Optional
        sortedBooks.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Книги отсутствуют")
        );
    }
}