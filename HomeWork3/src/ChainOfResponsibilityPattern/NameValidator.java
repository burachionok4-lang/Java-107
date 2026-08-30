package ChainOfResponsibilityPattern;

public class NameValidator extends StudentValidator {
    @Override
    protected void performValidation(Student student) throws ValidationException {
        if (student.getName() == null || student.getName().trim().isEmpty()) {
            throw new ValidationException("Имя студента не может быть null или пустым");
        }
        System.out.println("Имя прошло проверку");
    }
}
