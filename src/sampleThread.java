import java.util.Random;

/* Cameron Bradshaw */

public class sampleThread extends Thread {
    sampleThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        Random rand = new Random();
        int temp = rand.nextInt(1000);
        System.out.println(this.getName() + " is sleeping for " + temp + " milliseconds.");

        try {
            Thread.sleep(temp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
