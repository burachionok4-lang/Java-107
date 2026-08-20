import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private String bookName;
    private LocalDate releaseDate;
    private int pageCount;

    public Book(String bookName, LocalDate releaseDate, int pageCount) {

        this.bookName = bookName;
        this.releaseDate = releaseDate;
        this.pageCount = pageCount;
    }
    public Book(){}
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book that = (Book) o;
        return bookName.equals(that.bookName) && releaseDate.equals(that.releaseDate) && pageCount == that.pageCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, releaseDate, pageCount);
    }

    @Override
    public String toString() {
        return String.format("Book{name='%s', date=%s, pages=%d}",
                bookName, releaseDate, pageCount);

    }
}