/**
 * SessionManager class manages the user session within the application.
 * It provides functionality for logging in, logging out, and retrieving the current user.
 */
public class SessionManager {
    private static SessionManager instance; 
    private User currentUser;

    private SessionManager() {

    }

    public static SessionManager getInstance() { 
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
