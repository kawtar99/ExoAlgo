package playingwiththread;

public class ThisSynchronizer {

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
     * run the first thread and then the second thread
     * synchronized(this) blocks both methods
     * @param args
     */
    public static void main(String[] args) {
        ThisSynchronizer s1 = new ThisSynchronizer();
        Thread t1 = new Thread(s1::run1);
        Thread t2 = new Thread(s1::run2);

        t1.start();
        t2.start();
    }
}
