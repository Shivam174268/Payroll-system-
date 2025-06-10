import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conn {
    public Connection c;
    public Statement s;

    public Conn() {
        try {
            // Correct MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Correct MySQL connection string (update port, db name if needed)
            c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/payroll?useSSL=false&serverTimezone=UTC",
                    "root",
                    "");

            // Create statement object
            s = c.createStatement();

        } catch (Exception e) {
            // Proper logging
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
