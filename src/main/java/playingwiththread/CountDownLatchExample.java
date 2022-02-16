package playingwiththread;

import java.util.concurrent.CountDownLatch;

class Worker extends Thread {
    private CountDownLatch latch;

    public Worker(String name, CountDownLatch latch) {
        super(name);
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + " finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        // instance of CountDownLatch in main thread
        // intended to wait for 4 threads
        CountDownLatch latch = new CountDownLatch(4);

        Worker worker1 = new Worker("Worker1", latch);
        Worker worker2 = new Worker("Worker2", latch);
        Worker worker3 = new Worker("Worker3", latch);
        Worker worker4 = new Worker("Worker4", latch);

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        // The main task waits for four threads
        latch.await();

        Thread.sleep(500);
        // Main thread has started
        System.out.println(Thread.currentThread().getName() + " has finished");
    }

}
