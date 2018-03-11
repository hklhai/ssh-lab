package multithread.basic;

/**
 * Created by Ocean lin on 2017/9/8.
 */
public class SyncDubbo {

    public synchronized void m1() {
        System.out.println("m1 call");
        m2();
    }

    public synchronized void m2() {
        System.out.println("m2 call");
        m3();
    }

    public synchronized void m3() {
        System.out.println("m3 call");
    }

    public static void main(String[] args) {
        final SyncDubbo syncDubbo = new SyncDubbo();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                syncDubbo.m1();
            }
        });
        thread.start();
    }

}
