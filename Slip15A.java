import java.sql.*;
import java.util.*;
public class Slip15A {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String urlString = "jdbc:mysql://localhost:3306/atharva?user=root&password=root";
            Connection c1 = DriverManager.getConnection(urlString, null);
            Scanner sc= new Scanner(System.in);
            System.out.println("enter the id");
            int a=sc.nextInt();
            String qString = "update atharva.customer set address='mumbai' where id="+a;
            Statement st1 = c1.createStatement();
            st1.executeUpdate(qString);
            st1=c1.createStatement();
            String q2="select * from atharva.customer";
            ResultSet rSet=st1.executeQuery(q2);
            while (rSet.next()) {
                System.out.println("cid "+rSet.getInt(1)+" cname: "+rSet.getString(2)+" adddress: "+rSet.getString(3));
            }
            c1.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
