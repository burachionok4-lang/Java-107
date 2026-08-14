import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentName;
    private List<Book> studentBook = new ArrayList();

    public Student(String studentName, List<Book> studentBook) {
        this.studentName = studentName;
        this.studentBook = studentBook;
    }
    public String getStudentName(){
        return studentName;
    }
    public  List <Book> getStudentBook(){
        return studentBook;
    }
    @Override
    public String toString() {
        return "Student{studentName= '" + studentName + "'}";
    }
}