package AdapterPattern;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CsvBookAdapter implements BookSource {
    private final CsvBookReader csvReader;

    public CsvBookAdapter(CsvBookReader csvReader) {
        if (csvReader == null) {
            throw new IllegalArgumentException("CsvBookReader не может быть null");
        }
        this.csvReader = csvReader;
    }

    @Override
    public List<Book> getBooks() {
        String csvData = csvReader.readCsv();
        if (csvData == null || csvData.isEmpty()) {
            return Collections.emptyList();
        }

        List<Book> books = new ArrayList<>();
        String[] entries = csvData.split(";");

        for (String entry : entries) {
            if (entry == null || entry.trim().isEmpty()) {
                continue;
            }

            String[] parts = entry.split(",");
            if (parts.length != 3) {
                continue;
            }

            String title = parts[0].trim();
            String dateStr = parts[1].trim();
            String pagesStr = parts[2].trim();

            if (title == null || title.isEmpty()) {
                continue;
            }

            LocalDate date = null;
            if (dateStr != null && !dateStr.isEmpty()) {
                try {
                    date = LocalDate.parse(dateStr);
                } catch (DateTimeParseException e) {
                    continue;
                }
            }

            int pages = 0;
            if (pagesStr != null && !pagesStr.isEmpty()) {
                try {
                    pages = Integer.parseInt(pagesStr);
                } catch (NumberFormatException e) {
                    continue;
                }
            }

            books.add(new Book(title, date, pages));
        }
        return books;
    }
}