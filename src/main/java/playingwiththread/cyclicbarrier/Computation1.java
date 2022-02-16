package playingwiththread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;

class Computation1 implements Runnable {

    public static int product = 0;

    public void run() {
        product = 10;
        try {
            Thread.sleep(2000);
            CyclicBarrierExample.newBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
