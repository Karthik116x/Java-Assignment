package GeoLogisticsProject.shapes;

import javax.swing.*;
import java.awt.*;

public class Triangle extends Shape {
    double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a; this.b = b; this.c = c;
    }

    @Override
    public double calculateArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double calculatePerimeter() { return a + b + c; }

    @Override
    public void draw() {
        System.out.println("Launching GUI for Triangle...");

        JPanel panel = new JPanel() 
        {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLUE);
                
                // Simple representation: An equilateral-ish triangle for visualization
                // (Drawing a true triangle based on side lengths a,b,c is complex geometry,
                // so we represent it symbolically here)
                if (a + b <= c || a + c <= b || b + c <= a) {
                    System.out.println("Error: These side lengths cannot form a valid triangle.");
                } 
                else{
                    // 3. Calculate Coordinates
                    // Vertex A is fixed at (0, 0)
                    int Ax = 0;
                    int Ay = 0;

                    // Vertex B is fixed on the x-axis at distance 'c'
                    int Bx = (int)c;
                    int By = 0;

                    // Vertex C is calculated using the Law of Cosines derivation
                    // x = (c^2 + b^2 - a^2) / (2 * c)
                    double Cx1 = (Math.pow(c, 2) + Math.pow(b, 2) - Math.pow(a, 2)) / (2 * c);
                    int Cx = (int) (Cx1);
                    // y = sqrt(b^2 - x^2)
                    double Cy1 = Math.sqrt(Math.pow(b, 2) - Math.pow(Cx, 2));
                    int Cy = (int)(Cy1);
                    int[] xPoints = {0,0,Cx*50};
                    int[] yPoints = {0,Bx*50,Cy*50};
                    
                    g.fillPolygon(xPoints, yPoints, 3);
                    g.setColor(Color.BLACK);
                    g.drawString("Triangle Sides: " + a + ", " + b + ", " + c, 10, 20);
                }
            }
        };

        createFrame("Triangle Viewer", panel);
    }
}