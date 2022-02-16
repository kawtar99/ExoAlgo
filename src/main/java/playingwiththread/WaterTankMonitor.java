package playingwiththread;

public class WaterTankMonitor {

    private static class WaterTank {
        boolean isEmpty = false ;
        public boolean isEmpty() {
            return isEmpty;
        }
        public void setEmpty(boolean empty) {
            isEmpty = empty;
        }
    }

    private final WaterTank tank ;

    public WaterTankMonitor(WaterTank tank) {
        this.tank = tank;
    }

    void empty() {
        synchronized (tank){
            if(this.tank.isEmpty()){
                try {
                    tank.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("empty");
            this.tank.setEmpty(true);
            tank.notify();
        }

    }

    void fill()  {
        synchronized (tank){
            if(!this.tank.isEmpty()){
                try {
                    this.tank.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("fill");
            this.tank.setEmpty(false);
            tank.notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        var waterTankMonitor = new WaterTankMonitor(new WaterTank()) ;
        Thread t = new Thread(waterTankMonitor::fill);
        Thread t2 = new Thread(waterTankMonitor::fill);
        Thread t3 = new Thread(waterTankMonitor::empty);
        Thread t4 = new Thread(waterTankMonitor::empty);
        Thread t5 = new Thread(waterTankMonitor::fill);
        Thread t6 = new Thread(waterTankMonitor::empty);
        t3.start();
        //Thread.sleep(1000);
        t.start();
        //Thread.sleep(1000);
        t2.start();
        //Thread.sleep(1000);
        t4.start();
        //Thread.sleep(1000);
        t5.start();
        //Thread.sleep(1000);
        t6.start();
    }
}