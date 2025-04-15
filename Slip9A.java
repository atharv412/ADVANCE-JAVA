import java.sql.*;

public class Slip9A
{
    public static void main(String arg[]) throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        String url="jdbc:mysql://localhost:3306/atharva";
        String uname="root";
        String pwd="root";
        

        Connection con=DriverManager.getConnection(url,uname,pwd);

        Statement st= con.createStatement();

        // int n = Integer.parseInt(arg[0]);

        String qry="DELETE FROM atharva.employee WHERE ename like '%A'";

         st.executeUpdate(qry);

        System.out.println("delete record!");
        String newqry= " select * from employee ";
        ResultSet rt = st.executeQuery(newqry);
        
        while(rt.next())
        {
            System.out.println("\n Eno "+rt.getInt(1)+"Ename "+rt.getString(2)+"Salary "+rt.getInt(4));
        } 
        con.close();
    }
}