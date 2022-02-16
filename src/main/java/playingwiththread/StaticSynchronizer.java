package playingwiththread;

public class StaticSynchronizer {

    public static synchronized void run1() {
        System.out.println("Start run1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End run1");
    }

    public static synchronized void run2() {
        System.out.println("Start run2");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End run2");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(StaticSynchronizer::run1);
        Thread t2 = new Thread(StaticSynchronizer::run2);

        t1.start();
        t2.start();
    }
}
