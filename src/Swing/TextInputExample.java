package Swing;

import javax.swing.*;

public class TextInputExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Fields Example");
        JPanel panel = new JPanel();

        JTextField textField = new JTextField(15);
        JTextArea textArea = new JTextArea(5,15);
        JPasswordField passwordField = new JPasswordField(15);

        panel.add(new JLabel("Name:"));
        panel.add(textField);
        panel.add(new JLabel("Bio:"));
        panel.add(textArea);
        panel.add(new JLabel("Password"));
        panel.add(passwordField);

        frame.add(panel);
        frame.setSize(300,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
}
