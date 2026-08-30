package AdapterPattern;

import java.util.List;

public class CsvBookReader {
    // Возвращает строку в формате: "title,date,pages;title,date,pages;..."
    public String readCsv() {
        return "Война и мир,1950-01-15,1225;Преступление и наказание,1966-02-20,671;Гарри Поттер,1997-03-10,432";
    }
}
