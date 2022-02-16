package playingwiththread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentredLockSynchronizer {

    private ReentrantLock lock = new ReentrantLock();

    public void run1() {

        lock.lock();
            System.out.println("Start run1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End run1");
        lock.unlock();
    }

    public void run2() {
        lock.lock();
            System.out.println("Start run2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End run2");
        lock.unlock();
    }

    /**
     * run the first thread and then the second thread
     * lock blocks access to other methods
     * @param args
     */
    public static void main(String[] args) {
        ReentredLockSynchronizer s1 = new ReentredLockSynchronizer();
        Thread t1 = new Thread(s1::run1);
        Thread t2 = new Thread(s1::run2);

        t1.start();
        t2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" has queued Threads = "+ s1.lock.hasQueuedThreads());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(" has queued Threads = "+ s1.lock.hasQueuedThreads());
    }
}
