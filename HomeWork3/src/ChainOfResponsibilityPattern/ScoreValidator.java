package ChainOfResponsibilityPattern;

    public class ScoreValidator extends StudentValidator {
        @Override
        protected void performValidation(Student student) throws ValidationException {
            Double score = student.getScore();
            if (score != null) { // если балл указан, проверяем диапазон
                if (score < 0 || score > 5) {
                    throw new ValidationException("Средний балл должен быть от 0 до 5 (текущий: " + score + ")");
                }
            } // если null – пропускаем (балл не обязателен)
            System.out.println("Баллы прошли проверку");
        }
    }
