package GeoLogisticsProject.shapes;

import javax.swing.*;
import java.awt.*;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() { return Math.PI * radius * radius; }

    @Override
    public double calculatePerimeter() { return 2 * Math.PI * radius; }

    @Override
    public void draw() {
        System.out.println("Launching GUI for Circle...");
        
        // Create a custom JPanel for drawing
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                // Convert double radius to int for drawing
                int r = (int) radius * 20; // Scale up by 20x for visibility
                // Draw centered oval
                int x = (getWidth() - r) / 2;
                int y = (getHeight() - r) / 2;
                g.fillOval(x, y, r, r);
                g.setColor(Color.BLACK);
                g.drawString("Radius: " + radius, 10, 20);
            }
        };

        createFrame("Circle Viewer", panel);
    }
}