package aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ocean lin on 2019/12/3.
 *
 * @author Ocean lin
 */
public class Demo2 {


    /**
     * 重入锁
     * 排他锁
     * <p>
     * 公平锁
     * 非公平锁
     *
     * @param args
     */
    public static void main(String[] args) {
        final ReentrantLock lock = new ReentrantLock(true);
        Thread t1 = new Thread(() -> {
            lock.lock();
            logic();
            lock.unlock();
        }, "t1");
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(() -> {
            lock.lock();
            System.out.println("t2==========");
            lock.unlock();
        }, "t2");
        t2.start();

    }

    private static void logic() {
        System.out.println("t1 start===========");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t1 end===========");

    }
}
