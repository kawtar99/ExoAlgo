package playingwiththread;

public class DifferentInstanceSynchronizer {

    public void run1() {
        synchronized (this){
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
     * synchronized(this) does not block methods on different instances
     * @param args
     */
    public static void main(String[] args) {
        DifferentInstanceSynchronizer s1 = new DifferentInstanceSynchronizer();
        DifferentInstanceSynchronizer s2 = new DifferentInstanceSynchronizer();
        Thread t1 = new Thread(s1::run1);
        Thread t2 = new Thread(s2::run2);

        t1.start();
        t2.start();
    }
}
