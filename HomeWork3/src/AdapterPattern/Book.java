package AdapterPattern;

import java.time.LocalDate;

public class Book {
    private String title;
    private LocalDate releaseDate;
    private int pageCount;

    public Book(String title, LocalDate releaseDate, int pageCount) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.pageCount = pageCount;
    }

    public String getTitle() { return title; }
    public LocalDate getReleaseDate() { return releaseDate; }
    public int getPageCount() { return pageCount; }

    @Override
    public String toString() {
        return String.format("Book{title='%s', date=%s, pages=%d}",
                title, releaseDate, pageCount);
    }
}
