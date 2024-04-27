public class User {
    private String email;
    private String forename;
    private String surname;

    // Update the constructor to accept and initialize the surname as well
    public User(String email, String forename, String surname) {
        this.email = email;
        this.forename = forename;
        this.surname = surname;
    }

    // Getters and setters
    public String getEmail() {
        return email;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }
}
