import java.util.Random;
import java.util.concurrent.Callable;

/* Cameron Bradshaw */

public class sampleCallable implements Callable <Integer> {
    private int id;

    public sampleCallable(int Id) {
        this.id = Id;
    }

    @Override

    public Integer call() throws Exception {
        Random rand = new Random();
        int temp = rand.nextInt(100) + 100;
        try {
            Thread.sleep(temp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int randInt = rand.nextInt(29) + 1;
        Integer sq = randInt * randInt;
        System.out.println("Thread-" + id + " calculating the square of " + randInt + ".");

        return sq;
    }
}
