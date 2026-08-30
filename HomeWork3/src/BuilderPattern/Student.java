package BuilderPattern;

public class Student {
    private final String name;
    private final int age;
    // Необязательные поля
    private final String group;
    private final String email;
    private final String phone;
    private final double score;

    private Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.group = builder.group;
        this.email = builder.email;
        this.phone = builder.phone;
        this.score = builder.score;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public double getScore() {
        return score;
    }
    @Override
    public String toString() {
        return String.format(
                "Student{name='%s', age=%d, group='%s', email='%s', phone='%s', score=%.2f}",
                name, age, group, email, phone, score
        );
    }

    public static class Builder {
        // Константы для сообщений и диапазонов
        private static final int MIN_AGE = 16;
        private static final int MAX_AGE = 50;
        private static final double MIN_SCORE = 0.0;
        private static final double MAX_SCORE = 5.0;
        private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

        // Обязательные поля
        private final String name;
        private final int age;
        // Необязательные
        private String group;
        private String email;
        private String phone;
        private Double score;
        private boolean strictMode = true;

        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Builder group(String group) {
            this.group = group;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder score(Double score) {
            this.score = score;
            return this;
        }

        public Builder strictMode(boolean strict) {
            this.strictMode = strict;
            return this;
        }

        public Student build() {
            if (strictMode) {
                validateName();
                validateAge();
                validateGroup();
                validateEmail();
                validatePhone();
                validateScore();
            }
            return new Student(this);
        }

        private void validateName() {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Имя студента не может быть null или пустым");
            }
            if (name.length() < 2) {
                throw new IllegalArgumentException("Имя должно содержать минимум 2 символа");
            }
        }

        private void validateAge() {
            if (age < MIN_AGE || age > MAX_AGE) {
                throw new IllegalArgumentException(
                        "Возраст должен быть в диапазоне от " + MIN_AGE + " до " + MAX_AGE +
                                " (текущий: " + age + ")"
                );
            }
        }

        private void validateGroup() {
            if (group != null && group.trim().isEmpty()) {
                throw new IllegalArgumentException("Группа, если указана, не может быть пустой строкой");
            }
        }

        private void validateEmail() {
            if (email != null && !email.matches(EMAIL_REGEX)) {
                throw new IllegalArgumentException("Некорректный формат email: " + email);
            }
        }

        private void validatePhone() {
            if (phone != null) {
                String cleaned = phone.replaceAll("[\\s\\-()+]", "");
                if (!cleaned.matches("\\d+")) {
                    throw new IllegalArgumentException("Телефон должен содержать только цифры, пробелы, +, - и скобки: " + phone);
                }
            }
        }

        private void validateScore() {
            if (score != null && (score < MIN_SCORE || score > MAX_SCORE)) {
                throw new IllegalArgumentException(
                        "Средний балл должен быть в диапазоне от " + MIN_SCORE + " до " + MAX_SCORE +
                                " (текущий: " + score + ")"
                );
            }
        }
    }
}
