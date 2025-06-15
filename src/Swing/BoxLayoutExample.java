package Swing;

import javax.swing.*;

public class BoxLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BoxLayout Example");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertical

        panel.add(new JButton("Top"));
        panel.add(Box.createVerticalStrut(10)); // Spacer
        panel.add(new JButton("Middle"));
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JButton("Bottom"));

        frame.add(panel);
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
