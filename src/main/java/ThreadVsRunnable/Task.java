package ThreadVsRunnable;

import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Runnable{

    private AtomicInteger sharedResource = new AtomicInteger(0);

    @Override
    public void run() {
        sharedResource.incrementAndGet();
    }

    public AtomicInteger getSharedResource() {
        return sharedResource;
    }
}
