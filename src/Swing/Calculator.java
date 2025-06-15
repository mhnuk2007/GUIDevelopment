package Swing;

import javax.swing.*;
import java.awt.*;

public class Calculator {

    // Stores first operand
    private static double num1 = 0;

    // Stores the selected operator (+, -, *, /)
    private static String operator = "";

    // Flag to check if operator was just clicked
    private static boolean isOperatorClicked = false;

    public static void main(String[] args) {

        // Create main calculator frame
        JFrame frame = new JFrame("Calculator");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the frame

        // Create display field
        JTextField display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false); // User cannot type directly

        // Create panel with grid layout: 5 rows, 4 columns, with 5px gaps
        JPanel panel = new JPanel(new GridLayout(5, 4, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        // Calculator button labels
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "C", "=",
                "+" // This row will have 1 less button, grid auto adjusts
        };

        // Create and add buttons to panel
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            panel.add(button);

            // Add ActionListener to handle clicks
            button.addActionListener(e -> {
                String value = e.getActionCommand();

                switch (value) {
                    case "C":
                        // Clear display and reset all state
                        display.setText("");
                        operator = "";
                        num1 = 0;
                        isOperatorClicked = false;
                        break;

                    case "+": case "-": case "*": case "/":
                        // Store first number and selected operator
                        if (!display.getText().isEmpty()) {
                            num1 = Double.parseDouble(display.getText());
                            operator = value;
                            isOperatorClicked = true;
                        }
                        break;

                    case "=":
                        // Perform calculation and show result
                        if (!display.getText().isEmpty() && !operator.isEmpty()) {
                            double num2 = Double.parseDouble(display.getText());
                            double result = calculate(num1, num2, operator);
                            display.setText(String.valueOf(result));

                            // Reset after calculation
                            operator = "";
                            isOperatorClicked = false;
                        }
                        break;

                    case ".":
                        // Allow only one decimal point
                        if (!display.getText().contains(".")) {
                            display.setText(display.getText() + ".");
                        }
                        break;

                    default:
                        // Append digits to display
                        if (isOperatorClicked) {
                            display.setText(""); // Clear for new number
                            isOperatorClicked = false;
                        }
                        display.setText(display.getText() + value);
                        break;
                }
            });
        }

        // Set frame layout and add components
        frame.setLayout(new BorderLayout(10, 10));
        frame.add(display, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        // Show the calculator window
        frame.setVisible(true);
    }

    // Performs the arithmetic calculation
    private static double calculate(double a, double b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    // Handle division by zero error
                    JOptionPane.showMessageDialog(null, "Division by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    return 0;
                }
                return a / b;
            default:
                return 0;
        }
    }
}
