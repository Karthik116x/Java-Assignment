package GeoLogisticsProject.mypack;

public class PalletStack {
    private int[] stack;
    private int top;
    private int capacity;

    public PalletStack() {
        capacity = 10;
        stack = new int[capacity];
        top = -1;
    }

    // Producer Method
    public synchronized void push(int item) {
        while (top >= capacity - 1) {
            try {
                System.out.println(">> [Stack Full] RestockBot waiting...");
                wait();
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        stack[++top] = item;
        System.out.println("++ [RestockBot] Added Item ID: " + item);
        notifyAll();
    }

    // Consumer Method
    public synchronized int pop() {
        while (top < 0) {
            try {
                System.out.println(">> [Stack Empty] DispatchBot waiting...");
                wait();
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        int item = stack[top--];
        System.out.println("-- [DispatchBot] Shipped Item ID: " + item);
        notifyAll();
        return item;
    }
}