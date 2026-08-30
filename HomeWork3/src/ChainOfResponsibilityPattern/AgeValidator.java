package ChainOfResponsibilityPattern;

public class AgeValidator extends StudentValidator {
    @Override
    protected void performValidation(Student student) throws ValidationException {
        int age = student.getAge();
        if (age < 16 || age > 100) {
            throw new ValidationException("Возраст должен быть от 16 до 100 (текущий: " + age + ")");
        }
        System.out.println("Возраст прошёл проверку");
    }
}
