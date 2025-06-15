package Swing.Core;

import javax.swing.*;
import java.awt.*;

public class RegistrationForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Register");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Password:"));
        JPasswordField passField = new JPasswordField();
        panel.add(passField);

        panel.add(new JLabel("Confirm Password:"));
        JPasswordField confirmField = new JPasswordField();
        panel.add(confirmField);

        JButton register = new JButton("Register");
        panel.add(register);

        frame.add(panel);
        frame.setVisible(true);
    }
}
