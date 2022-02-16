package playingwiththread;

public class StaticClassSynchronizer {

    public static void run1() {
        synchronized (StaticClassSynchronizer.class){
            System.out.println("Start run1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End run1");
        }
    }

    public static void run2() {
        synchronized (StaticClassSynchronizer.class){
            System.out.println("Start run2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End run2");
        }
    }

    /**
     * run the first thread and then the second thread
     * synchronized blocks on the class method
     * @param args
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(StaticClassSynchronizer::run1);
        Thread t2 = new Thread(StaticClassSynchronizer::run2);

        t1.start();
        t2.start();
    }
}
