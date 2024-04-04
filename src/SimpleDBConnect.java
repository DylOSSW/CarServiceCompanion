import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement; // Import for PreparedStatement
/**
 *
 * @author Dylan Holmwood and Kristers Martukans
 */

public class SimpleDBConnect {
    // Making dbURL a class member so it's accessible throughout the class
    private String dbURL;

    public SimpleDBConnect() {
        // Initialize the dbURL variable
        String msAccDB = "..//admin.accdb"; // Corrected path to your Access database file
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
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Admin");

            System.out.println("#\tName\t\t\tManager\tStart");
            System.out.println("=====\t=========\t=======\t=======");

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t" +
                        resultSet.getString(2) + "\t\t" +
                        resultSet.getString(3));
            }
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        } finally {
            try {
                if (null != connection) {
                    resultSet.close();
                    statement.close();
                    connection.close();
                }
            } catch (SQLException sqlex) {
                System.err.println(sqlex.getMessage());
            }
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
    
    public ResultSet getAllCars() {
    try (Connection connection = DriverManager.getConnection(dbURL)) {
        String sql = "SELECT * FROM Cars"; // Assuming you have a table named 'Cars'
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    } catch (SQLException sqlex) {
        System.err.println(sqlex.getMessage());
    }
    return null;
}
    public static void main(String args[]){
        new SimpleDBConnect();
    }
} // End of Class
