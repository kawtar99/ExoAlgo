package playingwiththread;

import java.util.concurrent.*;

public class ExecutorServiceExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       ExecutorService executorService = Executors.newFixedThreadPool(2);

       executorService.execute(new Runnable() {
           @Override
           public void run() {
               System.out.println("Inside execute method " +
                       "Called with a Runnable");
           }
       });

       Future<String> resCallable = executorService.submit(new Callable<String>() {

           @Override
           public String call() throws Exception {
               System.out.println("Inside submit method");
               return "Invoked with a Callable";
           }
       });

       Future<?> resRunnable = executorService.submit(new Runnable() {
           @Override
           public void run() {
               System.out.println("Inside submit method " +
                       "Called with a Runnable");
           }
       });

       System.out.println("The result for Callable is : " + resCallable.get());
       System.out.println("The result for Runnable is : " + resRunnable.get());
    }
}
