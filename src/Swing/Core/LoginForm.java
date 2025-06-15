package Swing.Core;

import javax.swing.*;
import java.awt.*;

public class LoginForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        JPanel panel = new JPanel(new GridLayout(3, 2));

        panel.add(new JLabel("Username:"));
        JTextField userField = new JTextField();
        panel.add(userField);

        panel.add(new JLabel("Password:"));
        JPasswordField passField = new JPasswordField();
        panel.add(passField);

        JButton login = new JButton("Login");
        panel.add(login);

        frame.add(panel);
        frame.setVisible(true);
    }
}
