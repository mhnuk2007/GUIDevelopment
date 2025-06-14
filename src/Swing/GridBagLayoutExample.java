package Swing;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridBagLayout Example");
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JButton("Button 1"), gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(new JButton("Button 2"), gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(new JButton("Button 3"), gbc);

        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
