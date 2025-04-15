import java.sql.*;
import java.util.*;

public class Slip29B {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String urlString = "jdbc:mysql://localhost:3306/atharva?user=root&password=root";
            Connection c1 = DriverManager.getConnection(urlString, null);

            PreparedStatement pStatement;
            Scanner sc = new Scanner(System.in);
            int ch;
            ResultSet rSet;

            do {
                System.out.println("\n MENU");
                System.out.println("\n 1.INSERT");
                System.out.println("\n 2.UPDATE");
                System.out.println("\n 3.DELETE");
                System.out.println("\n 4.SEARCH");
                System.out.println("\n 5.DISPLAY");

                System.out.println("Enter choice");
                ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        String qString = "insert into student values(11,'zxcv',87)";//insert
                        pStatement = c1.prepareStatement(qString);
                        pStatement.executeUpdate();
                        System.out.println("Table updated Record inserted");
                        break;
                    case 2:
                        System.out.println("Enter rollno to be updated");//update
                        sc = new Scanner(System.in);
                        int roll = sc.nextInt();
                        System.out.println("Enter new name");
                        String nm = sc.next();
                        qString = "update atharva.student set sname=? where rno=?";
                        pStatement = c1.prepareStatement(qString);
                        pStatement.setString(1, nm);
                        pStatement.setInt(2, roll);
                        pStatement.executeUpdate();
                        System.out.println("Table updated Record inserted");
                        break;
                    case 3:
                        System.out.println("enter rollno to delete ");
                        roll = sc.nextInt();
                        qString = "delete from student where rno=?";
                        pStatement = c1.prepareStatement(qString);
                        pStatement.setInt(1, roll);
                        pStatement.executeUpdate();
                        System.out.println("Table updated Record deleted");
                        break;
                    case 4:
                        System.out.println("enter rollno to search ");
                        roll = sc.nextInt();
                        qString = "select * from student where rno=?";
                        pStatement = c1.prepareStatement(qString);
                        pStatement.setInt(1, roll);
                        rSet = pStatement.executeQuery();
                        while (rSet.next()) {
                            System.out.println("rollno" + rSet.getInt(1) + " name " + rSet.getString(2)+ " percenttage " + rSet.getInt(3));
                        }
                        // System.out.println("Table updated Record deleted");
                        break;
                    case 5:
                        System.out.println("students details");
                        qString = "select * from student";
                        pStatement = c1.prepareStatement(qString);
                        rSet = pStatement.executeQuery();
                        while (rSet.next()) {
                            System.out.println("rollno " + rSet.getInt(1) + " name " + rSet.getString(2)+ " percentage " + rSet.getInt(3));
                        }
                        break;
                }
            } while (ch < 6);
            c1.close();
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
