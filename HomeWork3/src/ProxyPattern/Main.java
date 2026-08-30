package ProxyPattern;

public class Main {
    public static void main(String[] args) {
                // Пользователь с ролью "user"
                Database dbUser = new DatabaseProxy("user");
                dbUser.executeQuery("SELECT * FROM students");   // безопасный запрос
                dbUser.executeQuery("DELETE FROM students WHERE id=1"); // опасный запрос

                System.out.println();

                // Пользователь с ролью "admin"
                Database dbAdmin = new DatabaseProxy("admin");
                dbAdmin.executeQuery("SELECT * FROM students");
                dbAdmin.executeQuery("DELETE FROM students WHERE id=1");

    }
}
