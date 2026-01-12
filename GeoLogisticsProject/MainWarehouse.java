package GeoLogisticsProject;
import GeoLogisticsProject.mypack.*;
import GeoLogisticsProject.shapes.*;
import GeoLogisticsProject.staff.*;
import GeoLogisticsProject.exceptions.DivisionByZeroException;
import java.util.Scanner;

public class MainWarehouse {
    
    static Scanner scanner = new Scanner(System.in);
    static Employee currentManager = null;
    static PalletStack warehouseStack = new PalletStack();

    // Inner Class (Req 8)
    static class SecuritySystem {
        public void display() { System.out.println("[Security] Systems Online."); }
    }

    // Outer Class Display (Req 8)
    public void display() { System.out.println("--- GEOLOGISTICS WAREHOUSE ---"); }

    public static void main(String[] args) {
        MainWarehouse warehouse = new MainWarehouse();
        warehouse.display();

        int N = 2;
        if (args.length > 0) {
            try { N = Integer.parseInt(args[0]); } catch (Exception e) {}
        } else {
            System.out.println("Tip: Pass N as argument for Matrix size. Defaulting to 2.");
        }

        boolean running = true;
        while (running) {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Matrix Addition (Manual Input)");
            System.out.println("2. Manage Employee");
            System.out.println("3. Navigation (Points)");
            System.out.println("4. Shapes & Resize (GUI)");
            System.out.println("5. Safety Check (Exception)");
            System.out.println("6. Run Robots (Thread Sync)");
            System.out.println("7. Inner Class Demo");
            System.out.println("8. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1: handleMatrixAddition(N); break;
                case 2: handleEmployee(); break;
                case 3: handleNavigation(); break;
                case 4: handleShapes(); break;
                case 5: handleSafetyCheck(); break;
                case 6: handleRobots(); break;
                case 7: 
                    warehouse.display();
                    new MainWarehouse.SecuritySystem().display();
                    break;
                case 8: running = false; break;
                default: System.out.println("Invalid.");
            }
        }
    }

    // --- Helpers ---

    private static void handleMatrixAddition(int N) {
        int[][] matA = new int[N][N];
        int[][] matB = new int[N][N];

        System.out.println("Enter Matrix A (" + N + "x" + N + "):");
        for(int i=0; i<N; i++) for(int j=0; j<N; j++) matA[i][j] = scanner.nextInt();

        System.out.println("Enter Matrix B (" + N + "x" + N + "):");
        for(int i=0; i<N; i++) for(int j=0; j<N; j++) matB[i][j] = scanner.nextInt();

        System.out.println("Sum Result:");
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) System.out.print((matA[i][j] + matB[i][j]) + "\t");
            System.out.println();
        }
    }

    private static void handleEmployee() {
        if(currentManager == null) {
            System.out.print("ID: "); int id = scanner.nextInt();
            System.out.print("Name: "); String name = scanner.next();
            System.out.print("Salary: "); double salary = scanner.nextDouble();
            currentManager = new Employee(id, name, salary);
            System.out.println("Hired.");
        } else {
            System.out.println(currentManager);
            System.out.print("Raise %: ");
            currentManager.raiseSalary(scanner.nextDouble());
        }
    }

    private static void handleNavigation() {
        System.out.print("Target X: "); int x = scanner.nextInt();
        System.out.print("Target Y: "); int y = scanner.nextInt();
        MyPoint p = new MyPoint(0,0);
        System.out.println("Distance from origin: " + p.distance(x, y));
    }

    // UPDATED METHOD: Now calls .draw() for both options to show GUI
    private static void handleShapes() {
        System.out.println("1. Circle Area  2. Rectangle");
        int op = scanner.nextInt();
        switch(op) {
        case 1:System.out.print("Radius: ");
            Circle c = new Circle(scanner.nextDouble());
            System.out.println("Area: " + c.calculateArea());
            c.draw(); // Launches Circle GUI
        case 2: 
        	System.out.println("Width= ");
        	int width=scanner.nextInt();
        	System.out.println("Height= ");
        	int height=scanner.nextInt();
            Rectangle r = new Rectangle(width,height);
            r.draw();
            // Launches Rectangle GUI
        case 3:System.out.print("a: ");
        	double x=scanner.nextDouble();
        	double y=scanner.nextDouble();
        	double z=scanner.nextDouble();
        	Triangle t = new Triangle(x,y,z);
        	System.out.println("Area: " + t.calculateArea());
        	t.draw();
        }
    }


    private static void handleSafetyCheck() {
        System.out.print("Inventory Count: ");
        int count = scanner.nextInt();
        try {
            if (count == 0) throw new DivisionByZeroException("Zero Inventory!");
            System.out.println("Density: " + (100 / count));
        } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
    }

    private static void handleRobots() {
        warehouseStack = new PalletStack();
        new RestockBot(warehouseStack).start();
        new DispatchBot(warehouseStack);
        try { Thread.sleep(6000); } catch (Exception e) {}
    }
}