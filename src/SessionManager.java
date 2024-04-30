// SessionManager class manages the user session within the application.
// It provides functionality for logging in, logging out, and retrieving the current user.
public class SessionManager {
    private static SessionManager instance; // Singleton instance for SessionManager
    private User currentUser; // Current logged-in user
    private Admin currentAdmin; // Current logged-in admin

    private SessionManager() {
        // Private constructor to prevent external instantiation
    }

    // Returns the singleton instance of SessionManager.
    // If the instance is null, creates a new instance.
    public static SessionManager getInstance() { 
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Logs in a user.
    public void login(User user) {
        currentUser = user;
    }
    
    // Logs in an admin.
    public void adminlogin(Admin admin) {
        currentAdmin = admin;
    }

    // Logs out the current user.
    public void logout() {
        currentUser = null;
    }
    
    // Logs out the current admin.
    public void adminlogout() {
        currentAdmin = null;
    }

    // Retrieves the current logged-in user.
    public User getCurrentUser() {
        return currentUser;
    }
    
    // Retrieves the current logged-in admin.
    public Admin getCurrentAdmin() {
        return currentAdmin;
    }

    // Checks if any user is logged in.
    public boolean isLoggedIn() {
        return currentUser != null;
    }
    
    // Checks if any admin is logged in.
    public boolean adminLoggedIn() {
        return currentAdmin != null;
    }
}
