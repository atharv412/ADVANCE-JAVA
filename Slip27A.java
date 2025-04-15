import java.sql.*;
import java.util.*;

public class Slip27A {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/atharva";
            String uname = "root";
            String pwd = "root";

            Connection con = DriverManager.getConnection(url, uname, pwd);

            Statement st = con.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the id of the employee to delete ");
            int id = sc.nextInt();

            String qry = "DELETE FROM atharva.employee WHERE eno=" + id;

            st.executeUpdate(qry);

            System.out.println("delete record!");
            con.close();
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
