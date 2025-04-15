import java.sql.*;

public class Slip11A {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String urlString = "jdbc:mysql://localhost:3306/atharva?user=root&password=root";

            Connection c1 = DriverManager.getConnection(urlString, null);
            String qString = "ALTER TABLE atharva.student DROP COLUMN percentage";
            Statement st1 = c1.createStatement();
            st1.executeUpdate(qString);
            c1.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
