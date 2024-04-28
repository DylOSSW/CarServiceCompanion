import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement; // Import for PreparedStatement

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
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
    

    
public boolean signUpNewUser(String forename, String surname, String email, String password, String address, String mobile) {
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
        String sql = "INSERT INTO Users (Forename, Surname, Email, Password, Address, Mobile, AccountStatus) VALUES (?, ?, ?, ?, ?, ?, 'Active')";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, forename);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, mobile);
            
            int rowsAffected = preparedStatement.executeUpdate();
            insertSuccess = rowsAffected > 0;
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    }
    return insertSuccess;
}


public DefaultTableModel searchCars(String selectedMake, String selectedModel, String minYear, String maxYear, String minPrice, String maxPrice, String selectedCondition) {
    DefaultTableModel model = new DefaultTableModel();
    System.out.println("Search button clicked."); // Debug statement
    try {
        Connection conn = DriverManager.getConnection(dbURL);
        String sql = "SELECT * FROM Vehicles WHERE 1=1";

        // Construct SQL query based on filter criteria
        // Add conditions based on the selected options
        if (!selectedMake.equals("All Makes")) {
            sql += " AND CarMake = '" + selectedMake + "'";
        }
        if (!selectedModel.equals("All Models")) {
            sql += " AND CarModel = '" + selectedModel + "'";
        }
        if (!minYear.equals("Min Year")) {
            sql += " AND CarYear >= '" + minYear + "'";
        }
        if (!maxYear.equals("Max Year")) {
            sql += " AND CarYear <= '" + maxYear + "'";
        }
        if (!minPrice.equals("Min Price")) {
            sql += " AND RentalPrice >= '" + minPrice + "'";
        }
        if (!maxPrice.equals("Max Price")) {
            sql += " AND RentalPrice <= '" + maxPrice + "'";
        }
        if (!selectedCondition.equals("Condition")) {
            sql += " AND Availability = '" + selectedCondition + "'";
        }
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        // Add column headers to the table model
        model.addColumn("CarID");
        model.addColumn("CarMake");
        model.addColumn("CarModel");
        model.addColumn("CarYear");
        model.addColumn("RentalPrice");
        model.addColumn("PurchasePrice");
        model.addColumn("Condition");
        model.addColumn("QuantityAvailable");
        model.addColumn("Availability");
        // Add rows of data to the table model
        while (rs.next()) {
            Object[] row = new Object[9];
            row[0] = rs.getInt("CarID");
            row[1] = rs.getString("CarMake");
            row[2] = rs.getString("CarModel");
            row[3] = rs.getInt("CarYear");
            row[4] = rs.getDouble("RentalPrice");
            row[5] = rs.getDouble("PurchasePrice");
            row[6] = rs.getString("Condition");
            row[7] = rs.getInt("QuantityAvailable");
            row[8] = rs.getBoolean("Availability");
            model.addRow(row);
        }
        // Set the table model to the JTable
        System.out.println("Table populated successfully."); // Debug statement

        // Close connections
        rs.close();
        stmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return model;
}


// Add function to populate combo boxes
    public void populateComboBox(JComboBox<String> comboBox, String columnName, String tableName) {
        try {
            Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT " + columnName + " FROM " + tableName);

            while (rs.next()) {
                comboBox.addItem(rs.getString(columnName));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean addNewVehicle(String make, String model, int year, double price, double purchasePrice, String condition, String imagePath) {
    String sql = "INSERT INTO Vehicles (CarMake, CarModel, CarYear, RentalPrice, PurchasePrice, Condition, Availability, ImagePath) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try (Connection connection = DriverManager.getConnection(dbURL);
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setString(1, make);
        preparedStatement.setString(2, model);
        preparedStatement.setInt(3, year);
        preparedStatement.setDouble(4, price);
        preparedStatement.setDouble(5, purchasePrice);
        preparedStatement.setString(6, condition);
        preparedStatement.setBoolean(7, true);
        preparedStatement.setString(8, imagePath);

        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        System.err.println("SQL Error: " + e.getMessage());
        return false;
    }
}
    
    public boolean updateVehicle(int carID, String make, String model, int year, double rentalPrice, double purchasePrice, String condition, String imagePath) {
    String sql = "UPDATE Vehicles SET CarMake = ?, CarModel = ?, CarYear = ?, RentalPrice = ?, PurchasePrice = ?, Condition = ?, ImagePath = ? WHERE CarID = ?";
    try (Connection connection = DriverManager.getConnection(dbURL);
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setString(1, make);
        preparedStatement.setString(2, model);
        preparedStatement.setInt(3, year);
        preparedStatement.setDouble(4, rentalPrice);
        preparedStatement.setDouble(5, purchasePrice);
        preparedStatement.setString(6, condition);
        preparedStatement.setString(7, imagePath);
        preparedStatement.setInt(8, carID);

        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        System.err.println("SQL Error: " + e.getMessage());
        return false;
    }
}



  public User userLogin1(String email, String password) {
        User user = null;
        try (Connection connection = DriverManager.getConnection(dbURL)) {
            String sql = "SELECT * FROM Users WHERE Email = ? AND Password = ?"; // Assuming your users table and columns are named like this
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String forename = resultSet.getString("Forename");
                        String surname = resultSet.getString("Surname");
                        // Assuming you have forename and surname columns in your Users table
                        user = new User(email, forename, surname);
                    }
                }
            }
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
        return user;
  }
}


   







