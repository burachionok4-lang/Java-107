import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Book> student1Book = new ArrayList();
        student1Book.add(new Book("Book1", LocalDate.of(2002,3,20),300));
        student1Book.add(new Book("Book2",LocalDate.of(1970,3,20), 2));
        student1Book.add(new Book("Book3",LocalDate.of(2006,3,20), 500));
        student1Book.add(new Book("Book4",LocalDate.of(2018,3,20), 600));
        student1Book.add(new Book("Book5",LocalDate.of(2002,3,20), 534));

        List<Book> student2Book = new ArrayList();
        student2Book.add(new Book("Book6", LocalDate.of(2005,3,20),253));
        student2Book.add(new Book("Book",LocalDate.of(2009,3,20), 244));
        student2Book.add(new Book("Book7",LocalDate.of(2006,3,20), 466));
        student2Book.add(new Book("Book8",LocalDate.of(2026,3,20), 987));
        student2Book.add(new Book("Book",LocalDate.of(2009,3,20), 244));

        List<Student> students = new ArrayList();
        students.add(new Student("Nikita",student1Book));
        students.add(new Student("Volodya",student2Book));
        Optional<Integer> sortedBooks = students.stream()
                .filter(Objects::nonNull)
                .peek(System.out::println)
                .peek(student -> System.out.println(student.getStudentBook()))
                .flatMap(student -> student.getStudentBook().stream())
                .filter(Objects::nonNull)
                .distinct()
                .peek(book -> System.out.println(book.getBookName()))
                .filter(book -> book.getReleaseDate() != null && book.getReleaseDate().getYear() >= 2000)
                .sorted(Comparator.comparingInt(Book::getPageCount))
                .limit(3)
                .map(Book::getReleaseDate)
                .map(LocalDate::getYear)
                .findFirst();
        sortedBooks.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Книги отсутствуют")
        );
        }
    }