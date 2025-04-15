import java.sql.*;

public class TestProg {
    public static void main(String[] args)throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url="jdbc:mysql://localhost:3306/atharva";
        String uname="root";
        String pwd="root";

        Connection c1=DriverManager.getConnection(url,uname,pwd);

        Statement st=c1.createStatement();

        String qry="create table hospital(id int, name varchar(40), address varchar(40))";

        // String qry="insert into hospital values(4,'zxcvbnm','asdfghjkl')";
        
        // String qry="ALTER TABLE customer ADD Ph_No int";

if (!qry.isBlank()) {
    System.out.println("table updated");
}
        st.executeUpdate(qry);

        c1.close();
    }
}