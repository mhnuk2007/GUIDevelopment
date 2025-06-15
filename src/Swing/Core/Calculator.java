package Swing.Core;

import javax.swing.*;
import java.awt.*;

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JTextField num1 = new JTextField();
        JTextField num2 = new JTextField();
        JTextField result = new JTextField();
        result.setEditable(false);

        JButton add = new JButton("Add");
        JButton subtract = new JButton("Subtract");

        panel.add(new JLabel("Number 1:"));
        panel.add(num1);
        panel.add(new JLabel("Number 2:"));
        panel.add(num2);
        panel.add(add);
        panel.add(subtract);
        panel.add(new JLabel("Result:"));
        panel.add(result);

        add.addActionListener(e -> {
            double a = Double.parseDouble(num1.getText());
            double b = Double.parseDouble(num2.getText());
            result.setText(String.valueOf(a + b));
        });

        subtract.addActionListener(e -> {
            double a = Double.parseDouble(num1.getText());
            double b = Double.parseDouble(num2.getText());
            result.setText(String.valueOf(a - b));
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
