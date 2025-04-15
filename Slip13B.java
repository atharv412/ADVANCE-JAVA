import java.time.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;


public class Slip13B extends JFrame {
    JComboBox<String> monthCombo;
    JTable table;
    DefaultTableModel model;

    Connection conn;

    public Slip13B() {
        setTitle("Book Sales by Month");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Top panel with month combo
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Select Month:"));

        String[] months = new String[12];
        for (int i = 0; i < 12; i++) {
            months[i] = Month.of(i + 1).name();
        }





// do this shit 







        monthCombo = new JComboBox<>(months);
        topPanel.add(monthCombo);

        add(topPanel, BorderLayout.NORTH);

        // Table to show sales
        model = new DefaultTableModel(new String[]{"SalesID", "Date", "Amount"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Load DB connection
        connectToDatabase();

        // Action on month selection
        monthCombo.addActionListener(e ->
         fetchSalesByMonth(monthCombo.getSelectedIndex() + 1));

        // Load current month's data by default
        fetchSalesByMonth(java.time.LocalDate.now().getMonthValue());

        setVisible(true);
    }

    private void connectToDatabase() {
        try {
            // Load driver (optional for newer JDBC)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to DB (change as needed)
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/atharva", "root", "root"
            );
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Database connection failed: " + ex.getMessage());
        }
    }

    private void fetchSalesByMonth(int month) {
        model.setRowCount(0); // clear table

        String query = "SELECT SalesID, Date, Amount FROM Book_Sales WHERE MONTH(Date) = ?";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setInt(1, month);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("SalesID");
                Date date = rs.getDate("Date");
                double amount = rs.getDouble("Amount");

                model.addRow(new Object[]{id, date, amount});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Query failed: " + ex.getMessage());
        }
    }
}

