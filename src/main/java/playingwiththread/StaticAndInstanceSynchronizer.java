package playingwiththread;

public class StaticAndInstanceSynchronizer {

    public static void run1() {
        synchronized (StaticAndInstanceSynchronizer.class){
            System.out.println("Start run1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End run1");
        }
    }

    public void run2() {
        synchronized (this){
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
     * the first thread and then the second thread run in parallel
     * synchronized(this) and synchronized(class) are not blocking the same thing
     * @param args
     */
    public static void main(String[] args) {
        StaticAndInstanceSynchronizer s1 = new StaticAndInstanceSynchronizer();
        Thread t1 = new Thread(StaticAndInstanceSynchronizer::run1);
        Thread t2 = new Thread(s1::run2);

        t1.start();
        t2.start();
    }
}
