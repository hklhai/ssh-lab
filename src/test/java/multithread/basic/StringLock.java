package multithread.basic;

/**
 * Created by Ocean lin on 2017/9/11.
 */
public class StringLock {

    public void method() {
        synchronized (new String("helloworld")) {
            while (true) {
                System.out.println("Current Thread " + Thread.currentThread().getName() + " Begin");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Current Thread " + Thread.currentThread().getName() + " Begin");
            }
        }
    }

    public static void main(String[] args) {
        final StringLock stringLock = new StringLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                stringLock.method();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                stringLock.method();
            }
        }, "t2");
        t1.start();
        t2.start();
    }

}
