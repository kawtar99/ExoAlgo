package playingwiththread.producerconsumer;

import java.util.LinkedList;
import java.util.Random;

class ProducerConsumer {

    private final int capacity;
    LinkedList<Integer> list = new LinkedList<>();

    ProducerConsumer(int capacity) {
        this.capacity = capacity;
    }

    private void produce() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (capacity == list.size()) {
                    wait();
                }
                // generate random integer between 1 and 10
                int value = new Random().nextInt(10);
                System.out.println("Producer produces value : " + value + ". New size is : " + list.size());
                list.add(value);
                notify();
                Thread.sleep(value * 100);
            }
        }
    }

    public void safeProduce(){
        try {
            produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (list.size() == 0) {
                    wait();
                }
                Integer value = list.removeFirst();
                System.out.println("Consumer consumes value " + value + ". New size is : " + list.size());
                notify();
                Thread.sleep(value * 100);
            }
        }
    }

    public void safeConsume(){
        try {
            consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
