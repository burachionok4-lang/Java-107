package ProxyPattern;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatabaseProxy implements Database {
    private final RealDatabase realDatabase;
    private final String userRole;

    // Запрещённые команды (можно расширять)
    private static final Pattern DANGEROUS_PATTERN =
            Pattern.compile("^\\s*(delete|drop|truncate|alter|create|insert|update)\\b", Pattern.CASE_INSENSITIVE);

    public DatabaseProxy(String userRole) {
        this.userRole = userRole;
        this.realDatabase = new RealDatabase();
    }

    @Override
    public void executeQuery(String query) {
        if (query == null || query.trim().isEmpty()) {
            System.out.println("Ошибка: пустой запрос");
            return;
        }

        System.out.println("[" + LocalDateTime.now() + "] " + userRole + " запросил: " + query);

        Matcher matcher = DANGEROUS_PATTERN.matcher(query);
        if (matcher.find()) {
            String command = matcher.group(1).toLowerCase();
            if (!"admin".equals(userRole)) {
                System.out.println("Ошибка: недостаточно прав для выполнения " + command + " - операции");
                return;
            }
            if (query.contains(";") && !query.endsWith(";")) {
                System.out.println("Предупреждение: множественный запрос от администратора, выполняется с осторожностью");
            }
        }

        if (!"admin".equals(userRole) && query.contains(";")) {
            System.out.println("Ошибка: запрос содержит разделитель ;, что запрещено для вашей роли");
            return;
        }

        try {
            realDatabase.executeQuery(query);
        } catch (Exception e) {
            System.err.println("Ошибка выполнения запроса: " + e.getMessage());
        }
    }
}