import java.sql.*;

public class Slip23B {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String urlString = "jdbc:mysql://localhost:3306/atharva?user=root&password=root";
            
            Connection c1 = DriverManager.getConnection(urlString, null);
            String qString;


            PreparedStatement pStatement;

            if (args.length > 0) {
                char ch = args[0].charAt(0);
                switch (ch) {
                    case 'R':
                        qString = "select * from elements";
                        pStatement = c1.prepareStatement(qString);
                        ResultSet rSet = pStatement.executeQuery();
                        while (rSet.next()) {
                            System.out.println("Name " + rSet.getString(1) + " Symbol" + rSet.getString(3) + " Weight"+ rSet.getInt(2));
                        }
                        break;
                    case 'U':
                        String s = args[2];
                        String name = args[1];
                        qString = "update elements set symbol=? where name=?";
                        pStatement = c1.prepareStatement(qString);
                        pStatement.setString(1, s);
                        pStatement.setString(2, name);
                        pStatement.executeUpdate();
                        System.out.println("Table updated");
                        break;
                    case 'D':
                        String name1 = args[1];
                        qString = "delete from elements where name=?";
                        pStatement = c1.prepareStatement(qString);
                        pStatement.setString(1, name1);
                        pStatement.executeUpdate();
                        System.out.println("Table updated record deleted");
                        break;
                }
            } else {
                System.out.println("Please select your option (R/U/D)");
            }
            c1.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
} 