import java.sql.*;

public class Slip10A {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
         
        String url="jdbc:mysql://localhost:3306/atharva";
        String uname="root";
        String pwd="root";

        Connection con=DriverManager.getConnection(url,uname,pwd);

        Statement st= con.createStatement();

        String qry= " select * from atharva.employee ";
        ResultSet rt = st.executeQuery(qry);
        int count=0;
        
        while(rt.next())
        {
            count++;
        } 
        System.out.println("THere are total "+count+"records in the table ");
        con.close();
    }
}
