package ThreadVsRunnable;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        Worker worker1 = new Worker();
        Worker worker2 = new Worker();
        Worker worker3 = new Worker();

        Task sharedTask = new Task();
        Thread thread1 = new Thread(sharedTask);
        Thread thread2 = new Thread(sharedTask);
        Thread thread3 = new Thread(sharedTask);

        worker1.start();
        worker2.start();
        worker3.start();

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Worker 1 result : " + worker1.getResource());
        System.out.println("Worker 1 result : " + worker2.getResource());
        System.out.println("Worker 1 result : " + worker3.getResource());

        System.out.println(sharedTask.getSharedResource());

    }
}
