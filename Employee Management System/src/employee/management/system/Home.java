package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{

    JButton view, add, update, remove, leaves, viewLeaves;

    Home() {

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/correcto.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(520, 20, 500, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        heading.setForeground(Color.white);
        image.add(heading);

        add = new JButton("Add Employee");
        add.setBounds(650, 80, 150, 40);
        add.addActionListener(this);
        image.add(add);

        view = new JButton("View Employees");
        view.setBounds(820, 80, 150, 40);
        view.addActionListener(this);
        image.add(view);

        update = new JButton("Update Employee");
        update.setBounds(650, 140, 150, 40);
        update.addActionListener(this);
        image.add(update);

        remove = new JButton("Remove Employee");
        remove.setBounds(820, 140, 150, 40);
        remove.addActionListener(this);
        image.add(remove);

        leaves = new JButton("Leaves");
        leaves.setBounds(650, 200, 150, 40);
        leaves.addActionListener(this);
        image.add(leaves);

        viewLeaves = new JButton("View Leaves");
        viewLeaves.setBounds(820, 200, 150, 40);
        viewLeaves.addActionListener(this);
        image.add(viewLeaves);

        setSize(1120, 630);
        setLocation(450, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == leaves) {
            setVisible(false);
            new ManageLeaves();
        } else if (ae.getSource() == viewLeaves) {
            setVisible(false);
            new ViewLeaves();
        } else {
            setVisible(false);
            new RemoveEmployee();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}