/**
 *
 * @author D21124318
 */
public class Admin {
    private int adminID;
    private String adminEmail;
    
    public Admin(int adminID, String adminEmail) {
        this.adminID = adminID;
        this.adminEmail = adminEmail;
    }
    
    public int getID() {
        return adminID;
    }
    
    public String getEmail() {
        return adminEmail;
    }
}