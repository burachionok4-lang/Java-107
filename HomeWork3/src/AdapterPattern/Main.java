package AdapterPattern;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Старая система
        CsvBookReader csvReader = new CsvBookReader();

        // Адаптер, который делает CSV-данные совместимыми с BookSource
        BookSource bookSource = new CsvBookAdapter(csvReader);

        // Клиент работает через интерфейс BookSource, не зная о CSV
        List<Book> books = bookSource.getBooks();
        books.forEach(System.out::println);
    }
}