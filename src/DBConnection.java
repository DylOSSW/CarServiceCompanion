/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author D21124318
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DBConnection {
    private static final String DB_URL = "jdbc:ucanaccess://..//CarRentalDB1.accdb";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    

    // Other database-related methods...
    
    
    public static DefaultTableModel searchCars(JComboBox<String> AllMakes, JComboBox<String> AllModels, JComboBox<String> MaxYear, JComboBox<String> MinYear, JComboBox<String> MaxPrice, JComboBox<String> MinPrice, JComboBox<String> Condition) {
        DefaultTableModel model = new DefaultTableModel();
        System.out.println("Search button clicked."); // Debug statement
        try {
            Connection conn = getConnection();
            String sql = "SELECT * FROM Vehicles";

            // Construct SQL query based on filter criteria
            // This part needs adjustment based on your UI components
            // You can use the selected index of combo boxes to construct your query
            // For simplicity, I'm assuming you have the necessary UI components passed as arguments
            // Adjust this logic according to your UI design
            // Add filters if necessary
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            
            // Add column headers to the table model
            model.addColumn("CarID");
            model.addColumn("CarMake");
            model.addColumn("CarModel");
            model.addColumn("CarYear");
            model.addColumn("RentalPrice");
            model.addColumn("PurchasePrice");
            model.addColumn("QuantityAvailable");
            model.addColumn("Availability");
            // Add rows of data to the table model
            while (rs.next()) {
                Object[] row = new Object[8];
                row[0] = rs.getInt("CarID");
                row[1] = rs.getString("CarMake");
                row[2] = rs.getString("CarModel");
                row[3] = rs.getInt("CarYear");
                row[4] = rs.getDouble("RentalPrice");
                row[5] = rs.getDouble("PurchasePrice");
                row[6] = rs.getInt("QuantityAvailable");
                row[7] = rs.getBoolean("Availability");
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
    public static void populateComboBox(JComboBox<String> comboBox, String columnName, String tableName) {
        try {
            Connection conn = getConnection();
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
}
