import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* Cameron Bradshaw */

public class Driver {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ES  = Executors.newFixedThreadPool(7);
        List< Future<?> > myFutures = new ArrayList<Future<?>>();

        for (int i = 0; i <= 49; i++) {
            String name = "Thread-" + i;
            sampleThread temp = new sampleThread(name);
            Future <?> f = ES.submit(temp);
            myFutures.add(f);
        }

        for ( Future<?> curfuture : myFutures ) {
            curfuture.get();
        }

        ES.shutdown();

        System.out.println("\n////////////////////////////////////////////////\n");

        ExecutorService ES2  = Executors.newCachedThreadPool();
        Future<Integer>[] myFutures2 = new Future[200];

        for (int i = 0; i <= 199; i++) {
            sampleCallable temp = new sampleCallable(i);
            Future <Integer> f = ES2.submit(temp);
            myFutures2[i] = f;
        }

        for (int i = 0; i <= 199; i++) {
            System.out.println("Result from Thread-" + i + ": " + myFutures2[i].get());
        }

        ES2.shutdown();
    }
}
