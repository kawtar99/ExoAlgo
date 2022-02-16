package playingwiththread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class CallableTask implements Callable {

    /**
     *
     * @return a randomly generated number between 1 and 5
     * @throws Exception
     */

    public Object call() throws Exception {
        Random generator = new Random();
        Integer randomNumber = generator.nextInt(5);

        Thread.sleep(randomNumber * 1000);

        return randomNumber;
    }

}

public class ThreadWithCallableFuture {

    public static void main(String[] args) throws Exception {

        FutureTask[] randomNumberTasks = new FutureTask[5];

        for (int i = 0; i < 5; i++) {
            Callable callable = new CallableTask();

            // Create FutureTask which are Runnable objects
            randomNumberTasks[i] = new FutureTask(callable);

            // Create a thread with a FutureTask to execute
            Thread t = new Thread(randomNumberTasks[i]);
            t.start();
        }

        for (int i = 0; i < 5; i++)
        {
            // As it implements Future, we can call get()
            System.out.println(randomNumberTasks[i].get());

            // This method blocks till the result is obtained
        }
    }

}
