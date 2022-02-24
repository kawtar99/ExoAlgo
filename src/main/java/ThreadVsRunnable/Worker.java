package ThreadVsRunnable;

import java.util.concurrent.atomic.AtomicInteger;

public class Worker extends Thread{

    private AtomicInteger resource = new AtomicInteger(0);

    @Override
    public void run(){
        resource.incrementAndGet();
    }

    public AtomicInteger getResource() {
        return resource;
    }
}
