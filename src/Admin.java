/**
 *
 * @author D21124318
 */
public class Admin {
    private int adminID; 
    private String adminEmail; 
    
    // Constructor for Admin class.
    public Admin(int adminID, String adminEmail) {
        this.adminID = adminID;
        this.adminEmail = adminEmail;
    }
    
    // Retrieves the admin's ID.
    public int getID() {
        return adminID;
    }
    
    // Retrieves the admin's email.
    public String getEmail() {
        return adminEmail;
    }
}
