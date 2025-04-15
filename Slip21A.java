import java.sql.*;
public class Slip21A {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/atharva";
        String username = "root";
        String Password = "root";
        
        Connection con = DriverManager.getConnection(url, username, Password);
        Statement st = con.createStatement();
        String quary = "Select * from employee where ename like '%s'";
        ResultSet rs = st.executeQuery(quary);
        while (rs.next()) 
        {
            System.out.println("emp no --"+rs.getInt(1)+"\t Emp name --"+rs.getString(2)+"\t dept --"+rs.getString(3)+"\tsalary--"+rs.getInt(4));
        }
        con.close();
    }
}
