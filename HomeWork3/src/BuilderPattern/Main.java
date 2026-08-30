package BuilderPattern;

public class Main {
    public static void main(String[] args) {
        //Студент только с обязательными полями
        Student student1 = new Student.Builder("Alice", 20)
                .build();
        System.out.println(student1);
        //Студент без имени
//        Student student2 = new Student.Builder(null, 16)
//                .build();
//        System.out.println(student2);
        //Студент со всеми полями
        Student student3 = new Student.Builder("Bob", 22)
                .group("CS-101")
                .email("bob@university.edu")
                .phone("+1234567890")
                .score(4.8)
                .build();
        System.out.println(student3);
        //Меняем порядок вызовов
        Student student4 = new Student.Builder("Charlie", 19)
                .score(4.2)
                .group("MATH-202")
                .email("charlie@mail.com")
                .build();
        System.out.println(student4);
    }
}
