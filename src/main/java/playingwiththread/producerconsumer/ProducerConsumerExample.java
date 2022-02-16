package playingwiththread.producerconsumer;

import playingwiththread.producerconsumer.ProducerConsumer;

public class ProducerConsumerExample {
    public static void main(String[] args) throws InterruptedException {
        final ProducerConsumer pc = new ProducerConsumer(3);

        // Create producer thread
        Thread producer = new Thread(pc::safeProduce);

        // Create consumer thread
        Thread consumer = new Thread(pc::safeConsume);

        // Start both threads
        producer.start();
        consumer.start();

        // Main thread waits for producer and consumer
        producer.join();
        consumer.join();
    }
}
