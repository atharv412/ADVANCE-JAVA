import java.sql.*;

public class Slip5A {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
         
        String url="jdbc:mysql://localhost:3306/atharva";
        String uname="root";
        String pwd="root";

        Connection con=DriverManager.getConnection(url,uname,pwd);

        Statement st= con.createStatement();

        String qry1="create table teacher1(Tno int, Tname varchar(40), Sal int, Desg varchar(40));";
        st.executeUpdate(qry1);
        System.out.println("Table created successfully");
        st= con.createStatement();

        String qry2="insert into teacher1 values(1,'abc',40000,'asfsdsadga')";
        st.executeUpdate(qry2);
        System.out.println("Record inserted successfully");
        st= con.createStatement();

        String qry3= " select * from teacher1 ";
        ResultSet rt = st.executeQuery(qry3);
        
        while(rt.next())
        {
            System.out.println("\n Tno "+rt.getInt(1)+"Tname "+rt.getString(2)+"Salary "+rt.getInt(3)+"Desg "+rt.getString(4));
        } 
        con.close();   
    }
}
