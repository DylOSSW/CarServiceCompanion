/**
 * SessionManager class manages the user session within the application.
 * It provides functionality for logging in, logging out, and retrieving the current user.
 */
public class SessionManager {
    private static SessionManager instance; 
    private User currentUser;
    private Admin currentAdmin;

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
    
    public void adminlogin(Admin admin) {
        currentAdmin= admin;
    }

    public void logout() {
        currentUser = null;
    }
    
    public void adminlogout() {
        currentAdmin = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }
    
    public Admin getCurrentAdmin() {
        return currentAdmin;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }
    
    public boolean adminLoggedIn() {
        return currentAdmin != null;
    }
}