/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
