import java.sql.*;

public class Slip6A{
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/atharva";
            String uName="root";
            String uPwd="root";
            Connection c1=DriverManager.getConnection(url,uName,uPwd);
            PreparedStatement ps;
            String qString="insert into customer(id,name,Address,Ph_No) values(?,?,?,?)";

            ps=c1.prepareStatement(qString);
            ps.setInt(1, 4);
            ps.setString(2, args[0]);
            ps.setString(3, args[1]);
            ps.setInt(4, Integer.parseInt(args[2]));
            ps.executeUpdate();
            System.out.println("Record Inserted using prepared statement");
            c1.close();
        } catch ( ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
