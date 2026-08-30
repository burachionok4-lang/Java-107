package ProxyPattern;

public class DatabaseFactory {
    public static Database createDatabase(String userRole) {
        return new DatabaseProxy(userRole);
    }
}
