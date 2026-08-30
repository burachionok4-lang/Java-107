package ChainOfResponsibilityPattern;

public class Student {
    private String name;
    private int age;
    private Double score;   // может быть null
    private String group;   // может быть null

    // Конструктор, геттеры, сеттеры
    public Student(String name, int age, Double score, String group) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.group = group;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public Double getScore() { return score; }
    public String getGroup() { return group; }

    @Override
    public String toString() {
        return String.format("Student{name='%s', age=%d, score=%s, group='%s'}",
                name, age, score, group);
    }
}
