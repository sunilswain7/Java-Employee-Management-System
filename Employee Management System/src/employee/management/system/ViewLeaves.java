package employee.management.system;

import javax.swing.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;

public class ViewLeaves extends JFrame {

    JTable table;

    ViewLeaves() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Leave Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        table = new JTable();
        table.setBounds(50, 100, 800, 500);
        add(table);

        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM leaves";
            ResultSet rs = conn.s.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(900, 700);
        setLocation(500, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ViewLeaves();
    }
}
