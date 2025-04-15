import java.sql.*;

public class Slip22B {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String urlString = "jdbc:mysql://localhost:3306/atharva?user=root&password=root";
            Connection c1 = DriverManager.getConnection(urlString, null);

            String qString = "create table student1(rno int, name varchar(40),percentage int);";
            Statement st = c1.createStatement();
            st.executeUpdate(qString);

            String qry2 = "insert into student1(rno,name,percentage) values(?,?,?)";
            PreparedStatement pst=c1.prepareStatement(qry2);
            pst.setInt(1, 102);
            pst.setString(2, "qwwerrty");
            pst.setInt(3, 87);
            pst.executeUpdate();
            System.out.println("Record inserted successfully");

            st= c1.createStatement();
            String q2="select * from atharva.student1";
            ResultSet rSet=st.executeQuery(q2);
            while (rSet.next()) {
                System.out.println("rno "+rSet.getInt(1)+" name: "+rSet.getString(2)+" percentage: "+rSet.getInt(3));
            }

            c1.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
