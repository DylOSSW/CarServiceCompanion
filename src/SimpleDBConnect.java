import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement; // Import for PreparedStatement
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
            String sql = "SELECT * FROM Users";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            // Print data from result set
            while (rs.next()) {
                int carID = rs.getInt("UserID");
                String carMake = rs.getString("Forename");
                String carModel = rs.getString("Surname");
                String carYear = rs.getString("Email");
                String rentalPrice = rs.getString("Address");
                String purchasePrice = rs.getString("Mobile");
                String quantityAvailable = rs.getString("AccountStatus");

                System.out.println("userid: " + carID + ", forename: " + carMake + ", surname: " + carModel +
                        ", email: " + carYear + ", address: " + rentalPrice + ", mobile: " + purchasePrice +
                        ", Account STATUS: " + quantityAvailable);
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
    
    public Admin adminLogin(String email, String password) {
    Admin admin = null;
    try (Connection connection = DriverManager.getConnection(dbURL)) {
        // Note the capitalization of the column names to match your database schema
            String sql = "SELECT * FROM Admin WHERE emailAddress = ? AND password = ?";        
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int adminID = resultSet.getInt("ID");
                        String adminEmail = resultSet.getString("emailAddress");

                        // Assuming that the email used for login is the same as in the database
                        admin = new Admin(adminID, adminEmail);
                    }
                }
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    }
    return admin;
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



    
public User userLogin(String email, String password) {
    User user = null;
    try (Connection connection = DriverManager.getConnection(dbURL)) {
        // Note the capitalization of the column names to match your database schema
        String sql = "SELECT UserID, Email, Forename, Surname, Address, Mobile FROM Users WHERE Email = ? AND Password = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int userID = resultSet.getInt("UserID");
                    String forename = resultSet.getString("Forename");
                    String surname = resultSet.getString("Surname");
                    String address = resultSet.getString("Address");
                    String mobileNumber = resultSet.getString("Mobile");
                    // Assuming that the email used for login is the same as in the database
                    user = new User(userID, email, forename, surname, address, mobileNumber);
                }
            }
        }
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    }
    return user;
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

/// VEHICLES ///
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
    
    // Add function to populate combo boxes
    public void populateDateComboBox(JComboBox<String> comboBox, String columnName, String tableName) {
        try {
            Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT " + columnName + " FROM " + tableName);

            DateTimeFormatter dateFormatterInput = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter dateFormatterOutput = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
            while (rs.next()) {
                String fullDate = rs.getString(columnName);
                //System.out.println(fullDate);
                LocalDate date = LocalDate.parse(fullDate.substring(0, 10), dateFormatterInput);
                String formattedDate = dateFormatterOutput.format(date);
                //System.out.println(formattedDate);
                //String trimmedDate = fullDate.substring(0, Math.min(fullDate.length(), 10)); // Get first 10 characters
                comboBox.addItem(formattedDate);
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

    public boolean deleteVehicle(int carID) {
    String sql = "DELETE FROM Vehicles WHERE CarID = ?";
    try (Connection connection = DriverManager.getConnection(dbURL);
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setInt(1, carID);

        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        System.err.println("SQL Error: " + e.getMessage());
        return false;
    }
}
    
/// USERS ///
    public DefaultTableModel searchUsers(String selectedForename, String selectedSurname, String selectedEmail, String selectedAddress, String selectedMobile, String selectedStatus) {
    DefaultTableModel usermodel = new DefaultTableModel();
    System.out.println("Search button clicked."); // Debug statement
    try {
        Connection conn = DriverManager.getConnection(dbURL);
        String sql = "SELECT * FROM Users WHERE 1=1";
        
        // Print initial SQL query
        //System.out.println("Initial SQL: " + sql);

        // Construct SQL query based on filter criteria
        // Add conditions based on the selected options
        if (!selectedForename.equals("Forename")) {
            sql += " AND Forename = '" + selectedForename + "'";
        }
        if (!selectedSurname.equals("Surname")) {
            sql += " AND Surname = '" + selectedSurname + "'";
        }
        if (!selectedEmail.equals("Email")) {
            sql += " AND Email = '" + selectedEmail + "'";
        }
        if (!selectedAddress.equals("Address")) {
            sql += " AND Address = '" + selectedAddress + "'";
        }
        if (!selectedMobile.equals("Mobile")) {
            sql += " AND Mobile = '" + selectedMobile + "'";
        }
        if (!selectedStatus.equals("Status")) {
            sql += " AND AccountStatus = '" + selectedStatus + "'";
        }
        
        // Print the final SQL query
        //System.out.println("Final SQL: " + sql);
        
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        // Debug: Check if ResultSet is empty
        if (!rs.isBeforeFirst()) {
            System.out.println("No data found matching query criteria.");
        }

        // Add column headers to the table model
        usermodel.addColumn("UserID");
        usermodel.addColumn("Forename");
        usermodel.addColumn("Surname");
        usermodel.addColumn("Email");
        usermodel.addColumn("Password");
        usermodel.addColumn("Address");
        usermodel.addColumn("Mobile");
        usermodel.addColumn("AccountStatus");
        
        // Add rows of data to the table model
        while (rs.next()) {
            //int userid = rs.getInt("UserID");
            //System.out.println("USERID FOUND: " + userid);
            
            Object[] row = new Object[8];
            row[0] = rs.getInt("UserID");
            row[1] = rs.getString("Forename");
            row[2] = rs.getString("Surname");
            row[3] = rs.getString("Email");
            row[4] = rs.getString("Password");
            row[5] = rs.getString("Address");
            row[6] = rs.getString("Mobile");
            row[7] = rs.getString("AccountStatus");
            usermodel.addRow(row);
        }
        // Set the table model to the JTable
        System.out.println("Users Table populated successfully."); // Debug statement
        //System.out.println(usermodel.getColumnName(0));
        //System.out.println(usermodel.getValueAt(1, 1));
        

        // Close connections
        rs.close();
        stmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return usermodel;
}
    
    public boolean addNewUser(String forename, String surname, String email, String address, String mobile) {
    String sql = "INSERT INTO Users (Forename, Surname, Email, Password, Address, Mobile, AccountStatus) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (Connection connection = DriverManager.getConnection(dbURL);
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setString(1, forename);
        preparedStatement.setString(2, surname);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, "Password123");
        preparedStatement.setString(5, address);
        preparedStatement.setString(6, mobile);
        preparedStatement.setString(7, "Active");

        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        System.err.println("SQL Error: " + e.getMessage());
        return false;
    }
}
    
    public boolean updateUser(int userID, String forename, String surname, String email, String password, String address, String mobile, String status ) {
    String sql = "UPDATE Users SET Forename = ?, Surname = ?, Email = ?, Password = ?, Address = ?, Mobile = ?, AccountStatus = ? WHERE UserID = ?";
    try (Connection connection = DriverManager.getConnection(dbURL);
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setString(1, forename);
        preparedStatement.setString(2, surname);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, password);
        preparedStatement.setString(5, address);
        preparedStatement.setString(6, mobile);
        preparedStatement.setString(7, status);
        preparedStatement.setInt(8, userID);

        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        System.err.println("SQL Error: " + e.getMessage());
        return false;
    }
}
    
    public boolean deleteUser(int userID) {
    String sql = "DELETE FROM Users WHERE UserID = ?";
    try (Connection connection = DriverManager.getConnection(dbURL);
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setInt(1, userID);

        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        System.err.println("SQL Error: " + e.getMessage());
        return false;
    }
}
    

    
    
///------///


/// OverDue Accounts ///
    
    public DefaultTableModel searchOverdue(String selectedUserID, String selectedRentalID, String selectedOverDueFrom, String selectedOverDueTo) {
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            // No cell can be edited
            return false;
        }
    };
    System.out.println("Search button clicked."); // Debug statement
    try {
        Connection conn = DriverManager.getConnection(dbURL);
        String sql = "SELECT * FROM OverdueAccounts WHERE 1=1";
                
        if (!selectedUserID.equals("UserID")) {
            sql += " AND UserID = '" + selectedUserID + "'";
        }
        if (!selectedRentalID.equals("RentalID")) {
            sql += " AND RentalID = '" + selectedRentalID + "'";
        }
        if (!selectedOverDueFrom.equals("OverDueFrom")) {
            sql += " AND OverDueDate >= '" + convertDateForAccess(selectedOverDueFrom) + "'";
        }
        if (!selectedOverDueTo.equals("OverDueTo")) {
            sql += " AND OverDueDate <= '" + convertDateForAccess(selectedOverDueTo) + "'";
        }
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        // Add column headers to the table model
        model.addColumn("UserID");
        model.addColumn("RentalID");
        model.addColumn("OverDueDate");
        
        // Add rows of data to the table model
        while (rs.next()) {
            Object[] row = new Object[3];
            row[0] = rs.getInt("UserID");
            row[1] = rs.getInt("RentalID");
            row[2] = rs.getDate("OverDueDate");
            
            model.addRow(row);
        }
        // Set the table model to the JTable
        System.out.println("Overdue Table populated successfully."); // Debug statement

        // Close connections
        rs.close();
        stmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return model;
}
    
    public Map<String, String> fetchOverdueAccountDetails(int userID, int rentalID) {
        Map<String, String> data = new HashMap<>();
        String sql = "SELECT u.Forename, u.Surname, u.Email, u.Address, u.Mobile, v.CarMake, v.CarModel, v.CarYear, r.ReturnDate " +
                     "FROM OverdueAccounts oa " +
                     "JOIN Users u ON oa.UserID = u.UserID " +
                     "JOIN Rented r ON oa.RentalID = r.RentalID " +
                     "JOIN Vehicles v ON r.CarID = v.CarID " +
                     "WHERE oa.UserID = ? AND oa.RentalID = ?";
        try (Connection conn = DriverManager.getConnection(dbURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userID);
            pstmt.setInt(2, rentalID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                data.put("Forename", rs.getString("Forename"));
                data.put("Surname", rs.getString("Surname"));
                data.put("Email", rs.getString("Email"));
                data.put("Address", rs.getString("Address"));
                data.put("Mobile", rs.getString("Mobile"));
                data.put("CarMake", rs.getString("CarMake"));
                data.put("CarModel", rs.getString("CarModel"));
                data.put("CarYear", rs.getString("CarYear"));
                data.put("ReturnDate", rs.getDate("ReturnDate").toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return data;
}
    
  private String convertDateForAccess(String dateStr) {
        // Assuming the input date is in dd-mm-yyyy format
        DateTimeFormatter originalFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Parse the date string to a LocalDate
        LocalDate date = LocalDate.parse(dateStr, originalFormat);

        // Format the LocalDate to the target format string
        return targetFormat.format(date);
} 
        
    
///------///


  
public List<Car> searchCars2(String selectedMake, String selectedModel, String minYear, String maxYear, String minPrice, String maxPrice, String selectedCondition) {
    List<Car> cars = new ArrayList<>();
    System.out.println("Search button clicked."); // Debug statement
    try {
        Connection conn = DriverManager.getConnection(dbURL);
        String sql = "SELECT CarID, CarMake, CarModel, CarYear, RentalPrice, PurchasePrice, Condition, QuantityAvailable, Availability, ImagePath FROM Vehicles WHERE 1=1";

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

        // Iterate over ResultSet and create Car objects
        while (rs.next()) {
            int carId = rs.getInt("CarID");
            String carMake = rs.getString("CarMake");
            String carModel = rs.getString("CarModel");
            int carYear = rs.getInt("CarYear");
            double rentalPrice = rs.getDouble("RentalPrice");
            double purchasePrice = rs.getDouble("PurchasePrice");
            String condition = rs.getString("Condition");
            int quantityAvailable = rs.getInt("QuantityAvailable");
            boolean availability = rs.getBoolean("Availability");
            String imagePath = rs.getString("ImagePath");  // Retrieve the actual image path from the database

            // Create Car object and add to list
            Car car = new Car(carId, carMake, carModel, carYear, rentalPrice, purchasePrice, quantityAvailable, availability, imagePath);
            cars.add(car);
        }

        // Close resources
        rs.close();
        stmt.close();
        conn.close();
    } catch (SQLException e) {
        System.out.println("SQL Exception: " + e.getMessage());
        e.printStackTrace();
    }
    return cars;
}

public boolean confirmPurchase(int carId) {
    boolean updateSuccess = false;
  

    String sqlUpdate = "UPDATE Vehicles SET Availability = FALSE WHERE CarID = ?";

    try (Connection conn = DriverManager.getConnection(dbURL);
         PreparedStatement ps = conn.prepareStatement(sqlUpdate)) {
        
        ps.setInt(1, carId);
        int rowsAffected = ps.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("Car ID " + carId + " has been marked as not available.");
            updateSuccess = true;
        } else {
            System.out.println("Car ID " + carId + " could not be updated. It may not exist.");
        }
        
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    }
    
    return updateSuccess;
}



  
  
  
}


   







