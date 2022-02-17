package playingwiththread;

import java.util.concurrent.*;

public class ExecutorServiceExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       ExecutorService executorService = Executors.newFixedThreadPool(2);

       executorService.execute(() -> {
           System.out.println("Inside " + Thread.currentThread().getName() + " execute method called with a Runnable");
           try {
               TimeUnit.MILLISECONDS.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       });


       Future<String> resCallable = executorService.submit(() -> {
           System.out.println("Inside " + Thread.currentThread().getName() + " submit method");
           try {
               TimeUnit.MILLISECONDS.sleep(2000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           return "Invoked with a Callable";
       });

       Future<?> resRunnable = executorService.submit(() -> {
           System.out.println("Inside " +  Thread.currentThread().getName() + " submit method Called with a Runnable");
           try {
               TimeUnit.MILLISECONDS.sleep(3000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       });

       // Callable result is a String
       System.out.println("The result for Callable is : " + resCallable.get());

       // Runnable result returns null
       System.out.println("The result for Runnable is : " + resRunnable.get());
    }
}
