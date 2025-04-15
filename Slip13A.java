import java.sql.*;;

public class Slip13A {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
         
        String url="jdbc:mysql://localhost:3306/atharva";
        String uname="root";
        String pwd="root";

        Connection con=DriverManager.getConnection(url,uname,pwd);

        Statement st= con.createStatement();

        String qry1="create table mobile(model varchar(40), company_name varchar(40), price int, color varchar(40));";
        st.executeUpdate(qry1);
        System.out.println("Table created successfully");
        st= con.createStatement();

        String qry2="insert into mobile(model,company_name,price,color) values(101,'samsung',15000,'blue')";
        st.executeUpdate(qry2);
        System.out.println("Record inserted successfully");
        st= con.createStatement();

        String qry3= " select * from atharva.mobile ";
        ResultSet rt = st.executeQuery(qry3);
        
        while(rt.next())
        {
            System.out.println("\n Tno "+rt.getInt(1)+"Tname "+rt.getString(2)+"Salary "+rt.getInt(3)+"Desg "+rt.getString(4));
        } 
        con.close();   
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
