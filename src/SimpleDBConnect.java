import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement; // Import for PreparedStatement

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author Dylan Holmwood and Kristers Martukans
 */

public class SimpleDBConnect {
    // Making dbURL a class member so it's accessible throughout the class
    private String dbURL;

    public SimpleDBConnect() {
        // Initialize the dbURL variable
        String msAccDB = "..//CarRentalDB1.accdb"; // Corrected path to your Access database file
        this.dbURL = "jdbc:ucanaccess://" + msAccDB; // Corrected JDBC URL

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException cnfex) {
            System.out.println("Problem in loading or registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(dbURL);
            
            // Execute SQL query to select all data from Vehicles table
            String sql = "SELECT * FROM Vehicles";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            // Print data from result set
            while (rs.next()) {
                int carID = rs.getInt("CarID");
                String carMake = rs.getString("CarMake");
                String carModel = rs.getString("CarModel");
                int carYear = rs.getInt("CarYear");
                double rentalPrice = rs.getDouble("RentalPrice");
                double purchasePrice = rs.getDouble("PurchasePrice");
                int quantityAvailable = rs.getInt("QuantityAvailable");
                boolean availability = rs.getBoolean("Availability");

                System.out.println("CarID: " + carID + ", CarMake: " + carMake + ", CarModel: " + carModel +
                        ", CarYear: " + carYear + ", RentalPrice: " + rentalPrice + ", PurchasePrice: " + purchasePrice +
                        ", QuantityAvailable: " + quantityAvailable + ", Availability: " + availability);
            }

            // Close connections
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean login(String email, String password) {
        boolean loginSuccess = false;
        try (Connection connection = DriverManager.getConnection(dbURL)) {
            String sql = "SELECT * FROM Admin WHERE emailAddress = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Check if the email contains the specific domain, not the password
                    if (resultSet.next() && email.contains("@carservicecompanion.ie")) {
                        loginSuccess = true;
                    }
                }
            }
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
        return loginSuccess;
        
    }
    
    public boolean updatePassword(String email, String newPassword) {
    String sql = "UPDATE Users SET Password = ? WHERE Email = ?";
    try (Connection connection = DriverManager.getConnection(dbURL);
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setString(1, newPassword);
        preparedStatement.setString(2, email);

        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Password updated successfully.");
            return true;
        }
    } catch (SQLException sqlex) {
        System.err.println("SQL Error: " + sqlex.getMessage());
    }
    return false;
}

    
public List<Car> getCarsFromDatabase() {
    List<Car> cars = new ArrayList<>();
    try {
        Connection connection = DriverManager.getConnection(dbURL);
        String sql = "SELECT * FROM Vehicles";
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                int carID = rs.getInt("CarID");
                String carMake = rs.getString("CarMake");
                String carModel = rs.getString("CarModel");
                int carYear = rs.getInt("CarYear");
                double rentalPrice = rs.getDouble("RentalPrice");
                double purchasePrice = rs.getDouble("PurchasePrice");
                int quantityAvailable = rs.getInt("QuantityAvailable");
                boolean availability = rs.getBoolean("Availability");
                String imagePath = rs.getString("ImagePath");

                Car car = new Car(carID, carMake, carModel, carYear, rentalPrice, 
                                  purchasePrice, quantityAvailable, availability, imagePath);
                cars.add(car);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return cars;
}



    
    public boolean userLogin(String email, String password) {
        boolean loginSuccess = false;
    try (Connection connection = DriverManager.getConnection(dbURL)) {
        String sql = "SELECT * FROM Users WHERE Email = ? AND Password = ?"; // Assuming your users table and columns are named like this
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) { // Just check if a record exists
                    loginSuccess = true;
                }
            }
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    }
    return loginSuccess;
}



    
public boolean signUpNewUser(String forename, String surname, String email, String password) {
    boolean insertSuccess = false;
    // You would define dbURL somewhere in your class, or pass it to the method
    try (Connection connection = DriverManager.getConnection(dbURL)) {
        // Check if the email already exists
        String checkEmailSQL = "SELECT * FROM Users WHERE Email = ?";
        try (PreparedStatement checkStmt = connection.prepareStatement(checkEmailSQL)) {
            checkStmt.setString(1, email);
            try (ResultSet resultSet = checkStmt.executeQuery()) {
                if (resultSet.next()) {
                    // If resultSet has an entry, it means the email already exists
                    System.out.println("Email already exists.");
                    return false;
                }
            }
        }

        // Proceed with inserting new user if email does not exist
        // Adding DateCreated and IsActive fields to the insert statement
        String sql = "INSERT INTO Users (Forename, Surname, Email, Password, Address, Mobile, AccountStatus) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, forename);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, "");
            preparedStatement.setString(6, "");
            preparedStatement.setString(7, "");
            
            int rowsAffected = preparedStatement.executeUpdate();
            insertSuccess = rowsAffected > 0;
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    }
    return insertSuccess;
}


}





