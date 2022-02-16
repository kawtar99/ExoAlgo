package playingwiththread;

import com.sun.source.tree.WhileLoopTree;

import java.util.LinkedList;
import java.util.Random;

class ProducerConsumer{

    private final int capacity;
    LinkedList<Integer> list = new LinkedList<>();

    ProducerConsumer(int capacity) {
        this.capacity = capacity;
    }

    public void produce() throws InterruptedException {
        while (true){
            synchronized (this){
                while (capacity == list.size()){
                    wait();
                }
                // generate random integer between 1 and 5
                Integer value = new Random().nextInt(10);
                System.out.println("Producer produces value : "+ value);
                list.add(value);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while(true) {
            synchronized (this) {
                while (list.size() == 0) {
                    wait();
                }
                Integer value = list.removeFirst();
                System.out.println("Consumer consumes value " + value);
                notify();
                Thread.sleep(1000);
            }
        }
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) throws InterruptedException {
        final ProducerConsumer pc = new ProducerConsumer(3);

        // Create producer thread
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    pc.produce();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create consumer thread
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    pc.consume();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // t1 finishes before t2
        t1.join();
        t2.join();
    }
}
