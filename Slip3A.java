import java.sql.*;

public class Slip3A {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/atharva";
            String uname = "root";
            String psrd = "root";

            Connection c1 = DriverManager.getConnection(url, uname, psrd);
            Statement st1 = c1.createStatement();
            String qryString = "select * from employee where department = 'Computer Science'";
            String qryString1="select * from employee ";
            ResultSet rs = st1.executeQuery(qryString1);
            while (rs.next()) {
                System.out.println("\nEno: " + rs.getInt(1) + "\nEname: " + rs.getString(2) + "\nDepartment: "
                        + rs.getString(3) + "\nSalary: " + rs.getInt(4));
            }
            c1.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
