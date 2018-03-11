package multithread.basic;

/**
 * Created by Ocean lin on 2017/9/6.
 */
public class MyThread extends Thread {


    private int count = 5;

    // 执行run方法时，以排队的方式进行处理，是以CPU分配的先后顺序而定的
    public synchronized void run() {
        count--;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        // 实例化5个线程
        Thread t1 = new Thread(thread, "t1");
        Thread t2 = new Thread(thread, "t2");
        Thread t3 = new Thread(thread, "t3");
        Thread t4 = new Thread(thread, "t4");
        Thread t5 = new Thread(thread, "t5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
