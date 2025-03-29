import java.util.HashMap;
import java.util.Map;

// User Authentication
public class UserAuth {
    private static final String USERS_FILE = "users.ser";
    private static Map<String, String> users = new HashMap<>();

    static {
        loadUsers();
    }

    private static void loadUsers() {
        FileHandler fileHandler = new FileHandler(USERS_FILE);
        Object data = fileHandler.readLogs();
        if (data instanceof Map) {
            users = (Map<String, String>) data;
        }
    }

    private static void saveUsers() {
        FileHandler fileHandler = new FileHandler(USERS_FILE);
        fileHandler.writeLog(users);
    }

    public static boolean register(String username, String password) {
        if (users.containsKey(username)) {
            return false;
        }
        users.put(username, password);
        saveUsers();
        return true;
    }

    public static boolean login(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}
