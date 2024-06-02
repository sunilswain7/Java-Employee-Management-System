package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {

    Splash() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/welcome.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1100, 650);
        add(image);

        JButton clickhere = new JButton("WELCOME");
        clickhere.setBounds(400, 400, 300, 70);
        clickhere.setBackground(Color.LIGHT_GRAY);
        clickhere.setForeground(Color.BLUE);
        clickhere.addActionListener(this);
        image.add(clickhere);


        setSize(1100, 650);
        setLocation(400, 200);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String args[]) {
        new Splash();
    }
}