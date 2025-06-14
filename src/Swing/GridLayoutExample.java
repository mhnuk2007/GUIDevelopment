package Swing;

import javax.swing.*;
import java.awt.*;

public class GridLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridLayout Example");
        JPanel panel = new JPanel(new GridLayout(2, 3)); // 2 rows, 3 columns

        for (int i = 1; i <= 6; i++) {
            panel.add(new JButton("Button " + i));
        }

        frame.add(panel);
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
