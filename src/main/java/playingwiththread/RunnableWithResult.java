package playingwiththread;

import java.util.Random;


/**
 * This class aims to use Runnable having attribute result as return type
 * the get method is simulating the blocking function of Future
 */
class RunnableWithResultExample implements Runnable{

    //Object storing the result of the run method
    private Object result = null;

    @Override
    public void run() {
        Random generator = new Random();
        int randomNumber = generator.nextInt(5);

        // handle the exception because the run method doesn't throw any exception
        try {
            Thread.sleep(randomNumber * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        result = randomNumber;

        // notify other threads that the current thread has finished its execution
        synchronized (this){
            notifyAll();
        }
    }

    // get the result once the thread has finished calculations
    public synchronized Object get() throws InterruptedException {
        while (result == null)
            wait();

        return result;
    }


    public static void main(String[] args) throws InterruptedException {
        RunnableWithResultExample[] randomNumberTasks = new RunnableWithResultExample[5];

        for (int i = 0; i < 5; i++)
        {
            randomNumberTasks[i] = new RunnableWithResultExample();
            Thread t = new Thread(randomNumberTasks[i]);
            t.start();
        }

        for (int i = 0; i < 5; i++)
            System.out.println(randomNumberTasks[i].get());
    }
}

