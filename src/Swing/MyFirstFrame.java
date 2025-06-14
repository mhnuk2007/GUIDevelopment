package Swing;
// 1. JFrame – The Main Window
import javax.swing.*;

public class MyFirstFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My first frame!");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
