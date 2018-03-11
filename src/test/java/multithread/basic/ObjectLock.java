package multithread.basic;

/**
 * Created by Ocean lin on 2017/9/11.
 */
public class ObjectLock {

    public void m1() {   //对象锁---ObjectLock
        synchronized (this) {
            System.out.println("m1 call!");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void m2() {
        //类锁
        synchronized (ObjectLock.class) {
            System.out.println("m2 call!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Object lock = new Object();
    public void m3() {
        synchronized (lock) {
            System.out.println("m3 call!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        final ObjectLock objectLock = new ObjectLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                objectLock.m1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                objectLock.m2();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                objectLock.m3();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }


}
