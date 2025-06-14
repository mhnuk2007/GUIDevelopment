package Swing;
// Practice: Build a login form with validation and confirmation dialog.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFormWithValidation {
    public static void main(String[] args) {
        // Create and show the login form
        JFrame frame = new JFrame("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel nameLabel = new JLabel("Username");
        JTextField nameField = new JTextField(15);

        JLabel passLabel = new JLabel("Password");
        JPasswordField passField = new JPasswordField(15);

        JButton loginButton = new JButton("Login");

        JLabel messageLabel = new JLabel();
        messageLabel.setForeground(Color.RED);

        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(new JLabel()); // Empty cell
        panel.add(loginButton);
        panel.add(new JLabel()); // Empty cell
        panel.add(messageLabel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = nameField.getText().trim();
                String password = new String(passField.getPassword());

                if (username.isEmpty()||password.isEmpty()){
                    messageLabel.setText("Please fill in all fields.");
                    return;
                }

                if (username.equalsIgnoreCase("Honey") && password.equals("1234")) {
                    int confirm = JOptionPane.showConfirmDialog(
                            frame,
                            "Are you sure you want to login",
                            "Confirm login",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (confirm == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(
                                frame,
                                "Login Successful",
                                "Welcome",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
                    else
                    {
                        JOptionPane.showMessageDialog(
                                frame,
                                "Invalid username or password!",
                                "Login failed",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }

                }
        });
        frame.add(panel);
        frame.setVisible(true);
    }
}
