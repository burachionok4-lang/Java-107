package ChainOfResponsibilityPattern;

public abstract class StudentValidator {
    protected StudentValidator next;

    // Метод для установки следующего обработчика (возвращаем this для цепочки)
    public StudentValidator setNext(StudentValidator next) {
        this.next = next;
        return next;
    }

    // Основной метод валидации (шаблонный метод)
    public void validate(Student student) throws ValidationException {
        // Проверяем, что сам студент не null
        if (student == null) {
            throw new ValidationException("Студент не может быть null");
        }
        // Выполняем конкретную проверку в подклассе
        performValidation(student);
        // Передаём дальше, если есть следующий обработчик
        if (next != null) {
            next.validate(student);
        }
    }

    // Абстрактный метод для реализации проверки в наследниках
    protected abstract void performValidation(Student student) throws ValidationException;
}
