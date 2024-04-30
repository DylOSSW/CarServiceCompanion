// Represents a user in the system
public class User {
    private int id; // New field for user ID
    private String email;
    private String forename;
    private String surname;
    private String address;
    private String mobileNumber;

    // Constructor for creating a new user
    public User(int id, String email, String forename, String surname, String address, String mobileNumber) {
        this.id = id;
        this.email = email;
        this.forename = forename;
        this.surname = surname;
        this.address = address;
        this.mobileNumber = mobileNumber;
    }

    // Retrieves the ID of the user
    public int getId() {
        return id;
    }

    // Retrieves the email address of the user
    public String getEmail() {
        return email;
    }

    // Retrieves the first name of the user
    public String getForename() {
        return forename;
    }

    // Retrieves the last name of the user
    public String getSurname() {
        return surname;
    }
    
    // Retrieves the address of the user
    public String getAddress() {
        return address;
    }
    
    // Retrieves the mobile number of the user
    public String getMobileNumber() {
        return mobileNumber;
    }
}
