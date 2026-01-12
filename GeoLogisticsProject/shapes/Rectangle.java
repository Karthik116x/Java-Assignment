package GeoLogisticsProject.shapes;

import javax.swing.*;
import java.awt.*;

public class Rectangle extends Shape implements Resizable {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // --- Shape Logic ---
    @Override
    public double calculateArea() { return width * height; }
    
    @Override
    public double calculatePerimeter() { return 2 * (width + height); }

    @Override
    public void draw() {
        System.out.println("Launching GUI for Rectangle...");
        
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.GREEN);
                
                // Scale by 10 for visibility, center it
                int w = width * 10;
                int h = height * 10;
                int x = (getWidth() - w) / 2;
                int y = (getHeight() - h) / 2;
                
                g.fillRect(x, y, w, h);
                g.setColor(Color.BLACK);
                g.drawString("Dims: " + width + "x" + height, 10, 20);
            }
        };

        createFrame("Rectangle Viewer", panel);
    }

    // --- Resizable Logic ---
    @Override
    public void resizeWidth(int width) {
        this.width = width;
        System.out.println("Resized Width to: " + this.width);
        // Automatically redraw if resized? 
        // For this simple project, we just update the data. 
        // Call draw() again to see the change.
    }

    @Override
    public void resizeHeight(int height) {
        this.height = height;
        System.out.println("Resized Height to: " + this.height);
    }
}