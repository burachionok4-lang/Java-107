package ChainOfResponsibilityPattern;

public class Main {
    public static void main(String[] args) {
        // Строим цепочку: Name -> Age -> Score -> Group
        StudentValidator nameValidator = new NameValidator();
        StudentValidator ageValidator = new AgeValidator();
        StudentValidator scoreValidator = new ScoreValidator();
        StudentValidator groupValidator = new GroupValidator();

        nameValidator.setNext(ageValidator)
                .setNext(scoreValidator)
                .setNext(groupValidator);

        // ----- Валидный студент -----
        Student validStudent = new Student("Alice", 20, 4.5, "CS-101");
        try {
            nameValidator.validate(validStudent);
            System.out.println("Студент валиден: " + validStudent);
        } catch (ValidationException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n---\n");

        // ----- Студент с null-именем -----
        Student invalidName = new Student(null, 20, 4.0, "CS-102");
        try {
            nameValidator.validate(invalidName);
        } catch (ValidationException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n---\n");

        // ----- Студент с неверным возрастом -----
        Student invalidAge = new Student("Bob", 15, 3.5, "CS-103");
        try {
            nameValidator.validate(invalidAge);
        } catch (ValidationException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n---\n");

        // ----- Студент с null-группой (валидно) -----
        Student noGroup = new Student("Charlie", 22, null, null);
        try {
            nameValidator.validate(noGroup);
            System.out.println("Студент валиден: " + noGroup);
        } catch (ValidationException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n---\n");

        // ----- Студент = null (проверка в базовом классе) -----
        try {
            nameValidator.validate(null);
        } catch (ValidationException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
