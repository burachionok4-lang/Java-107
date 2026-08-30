package ChainOfResponsibilityPattern;

public class GroupValidator extends StudentValidator {
    @Override
    protected void performValidation(Student student) throws ValidationException {
        String group = student.getGroup();
        if (group != null && group.trim().isEmpty()) {
            throw new ValidationException("Группа, если указана, не может быть пустой");
        }
        System.out.println("Группа прошла проверку");
    }
}
