package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class ManageLeaves extends JFrame implements ActionListener {

    JComboBox<String> empIdDropdown;
    JDateChooser fromDateField, toDateField;
    JButton grantLeave, denyLeave, back;

    ManageLeaves() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Manage Leaves");
        heading.setBounds(110, 20, 250, 30);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        add(heading);

        JLabel empIdLabel = new JLabel("Employee ID:");
        empIdLabel.setBounds(50, 80, 200, 30);
        empIdLabel.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(empIdLabel);

        empIdDropdown = new JComboBox<>(getEmployeeIds());
        empIdDropdown.setBounds(200, 80, 150, 30);
        add(empIdDropdown);

        JLabel fromDateLabel = new JLabel("From Date:");
        fromDateLabel.setBounds(50, 130, 150, 30);
        fromDateLabel.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(fromDateLabel);

        fromDateField = new JDateChooser();
        fromDateField.setBounds(200, 130, 150, 30);
        add(fromDateField);

        JLabel toDateLabel = new JLabel("To Date:");
        toDateLabel.setBounds(50, 180, 150, 30);
        toDateLabel.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(toDateLabel);

        toDateField = new JDateChooser();
        toDateField.setBounds(200, 180, 150, 30);
        add(toDateField);

        grantLeave = new JButton("Grant Leave");
        grantLeave.setBounds(50, 230, 150, 30);
        grantLeave.addActionListener(this);
        add(grantLeave);

        denyLeave = new JButton("Deny Leave");
        denyLeave.setBounds(220, 230, 150, 30);
        denyLeave.addActionListener(this);
        add(denyLeave);

        back = new JButton("Back");
        back.setBounds(130, 280, 150, 30);
        back.addActionListener(this);
        add(back);

        setSize(450, 400);
        setLocation(450, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String empId = (String) empIdDropdown.getSelectedItem();
        String fromDate = ((JTextField) fromDateField.getDateEditor().getUiComponent()).getText();
        String toDate = ((JTextField) toDateField.getDateEditor().getUiComponent()).getText();

        if (ae.getSource() == grantLeave) {
            manageLeave(empId, fromDate, toDate, "Granted");
        } else if (ae.getSource() == denyLeave) {
            manageLeave(empId, fromDate, toDate, "Denied");
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Home();
        }
    }

    private void manageLeave(String empId, String fromDate, String toDate, String status) {
        try {
            Conn conn = new Conn();
            String query = "INSERT INTO leaves (empId, fromDate, toDate, status) VALUES ('" + empId + "', '" + fromDate + "', '" + toDate + "', '" + status + "')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Leave " + status + " for Employee ID: " + empId);
            setVisible(false);
            new Home();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String[] getEmployeeIds() {
        ArrayList<String> empIds = new ArrayList<>();
        try {
            Conn conn = new Conn();
            String query = "SELECT empId FROM employee";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                empIds.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empIds.toArray(new String[0]);
    }

    public static void main(String[] args) {
        new ManageLeaves();
    }
}
