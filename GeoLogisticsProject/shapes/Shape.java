package GeoLogisticsProject.shapes;

import javax.swing.*;
import java.awt.*;

public abstract class Shape {
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    
    // Abstract draw method to force subclasses to implement their own GUI
    public abstract void draw();

    // Helper method to create a window for the shape
    protected void createFrame(String title, JPanel panel) {
        JFrame frame = new JFrame(title);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null); // Center the window
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window, not the app
        frame.add(panel);
        frame.setVisible(true);
    }
}