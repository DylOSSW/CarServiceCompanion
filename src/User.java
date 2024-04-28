public class User {
    private int id; // New field for user ID
    private String email;
    private String forename;
    private String surname;
    private String address;
    private String mobileNumber;

    // Updated constructor to accept and initialize the additional fields
    public User(int id, String email, String forename, String surname, String address, String mobileNumber) {
        this.id = id;
        this.email = email;
        this.forename = forename;
        this.surname = surname;
        this.address = address;
        this.mobileNumber = mobileNumber;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }
    
    public String getAddress() {
        return address;
    }
    
  
    public String getMobileNumber() {
        return mobileNumber;
    }
    

}
