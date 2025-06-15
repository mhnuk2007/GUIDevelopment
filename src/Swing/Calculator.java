package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator {

    private static double num1 = 0;
    private static String operator = "";
    private static boolean isOperatorClicked = false;

    public static void main(String[] args) {

        // Create frame
        JFrame frame = new JFrame("Calculator");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Create display field
        JTextField display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);

        // Button labels
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "C", "=",
                "+" // one extra button will fit automatically
        };

        // Create panel
        JPanel panel = new JPanel(new GridLayout(5, 4, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create buttons and add to panel
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            panel.add(button);

            button.addActionListener(e -> processInput(display, e.getActionCommand()));
        }

        // Add keyboard support
        addKeyBindings(frame, display);

        // Layout
        frame.setLayout(new BorderLayout(10, 10));
        frame.add(display, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

        // Request focus for key bindings to work
        SwingUtilities.invokeLater(display::requestFocusInWindow);
    }

    // Process logic for button and keyboard input
    private static void processInput(JTextField display, String value) {
        switch (value) {
            case "C":
                display.setText("");
                operator = "";
                num1 = 0;
                isOperatorClicked = false;
                break;

            case "+": case "-": case "*": case "/":
                if (!display.getText().isEmpty()) {
                    num1 = Double.parseDouble(display.getText());
                    operator = value;
                    isOperatorClicked = true;
                }
                break;

            case "=":
                if (!display.getText().isEmpty() && !operator.isEmpty()) {
                    double num2 = Double.parseDouble(display.getText());
                    double result = calculate(num1, num2, operator);
                    display.setText(String.valueOf(result));
                    operator = "";
                    isOperatorClicked = false;
                }
                break;

            case ".":
                if (!display.getText().contains(".")) {
                    display.setText(display.getText() + ".");
                }
                break;

            default: // digits
                if (isOperatorClicked) {
                    display.setText("");
                    isOperatorClicked = false;
                }
                display.setText(display.getText() + value);
                break;
        }
    }

    // Add keyboard key bindings
    private static void addKeyBindings(JFrame frame, JTextField display) {
        JPanel root = (JPanel) frame.getContentPane();
        InputMap im = root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = root.getActionMap();

        String keys = "0123456789.+-*/=cC\n\r";
        for (char c : keys.toCharArray()) {
            im.put(KeyStroke.getKeyStroke(c), "pressed_" + c);
            am.put("pressed_" + c, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (c) {
                        case '\n': case '\r': processInput(display, "="); break; // Enter
                        case 'c': case 'C': processInput(display, "C"); break;
                        default: processInput(display, String.valueOf(c));
                    }
                }
            });
        }

        // Support backspace to delete last digit
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "backspace");
        am.put("backspace", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = display.getText();
                if (!text.isEmpty()) {
                    display.setText(text.substring(0, text.length() - 1));
                }
            }
        });
    }

    // Perform calculation
    private static double calculate(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) {
                    JOptionPane.showMessageDialog(null, "Division by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    return 0;
                }
                return a / b;
            default: return 0;
        }
    }
}
