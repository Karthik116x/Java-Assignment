package GeoLogisticsProject.staff;
import GeoLogisticsProject.mypack.PalletStack;

public class RestockBot implements Runnable {
    PalletStack stack;

    public RestockBot(PalletStack stack) { this.stack = stack; }

    public void start() { new Thread(this).start(); }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                stack.push(i * 100);
                Thread.sleep(800);
            }
        } catch (InterruptedException e) {}
    }
}