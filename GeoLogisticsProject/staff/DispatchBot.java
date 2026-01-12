package GeoLogisticsProject.staff;
import GeoLogisticsProject.mypack.PalletStack;

public class DispatchBot extends Thread {
    PalletStack stack;

    public DispatchBot(PalletStack stack) {
        super();
        this.stack = stack;
        start();
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                stack.pop();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {}
    }
}