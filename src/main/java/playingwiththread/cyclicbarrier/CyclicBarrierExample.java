package playingwiththread.cyclicbarrier;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class CyclicBarrierExample implements Runnable {

    public static CyclicBarrier newBarrier = new CyclicBarrier(3);

    public static void main(String[] args) {
        // parent thread
        CyclicBarrierExample test = new CyclicBarrierExample();

        Thread t1 = new Thread(test);
        t1.start();
    }
    public void run() {

        System.out.println("Number of parties required to trip the barrier = "+
                newBarrier.getParties());
        System.out.println("Sum of product and sum = " + (Computation1.product +
                Computation2.sum));

        // objects on which the child thread has to run
        Computation1 comp1 = new Computation1();
        Computation2 comp2 = new Computation2();

        // creation of child thread
        Thread t1 = new Thread(comp1);
        Thread t2 = new Thread(comp2);

        // moving child thread to runnable state
        t1.start();
        t2.start();

        try {
            CyclicBarrierExample.newBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        // barrier breaks as the number of thread waiting for the barrier
        // at this point = 3
        System.out.println("Sum of product and sum = " + (Computation1.product +
                Computation2.sum));

        // Resetting the newBarrier
        newBarrier.reset();
        System.out.println("Barrier reset successful");
    }
}