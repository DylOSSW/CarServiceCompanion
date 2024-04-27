public class SessionManager {
    private static SessionManager instance; // This should be static
    private User currentUser;

    private SessionManager() {
        // private constructor to prevent instantiation
    }

    public static SessionManager getInstance() { // This should be static
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void login(User user) {
        currentUser = user;
    }

    public void logout() {
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }
}
