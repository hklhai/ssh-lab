package multithread.sync07;

import multithread.basic.RunThraed;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Ocean lin on 2017/9/13.
 */
public class AtomicUse {

    private static AtomicInteger count = new AtomicInteger(0);

    //多个addAndGet在一个方法内是非原子性的，需要加synchronized进行修饰，保证4个addAndGet整体原子性
    /**synchronized*/
    public synchronized int mutilAdd() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count.addAndGet(1);
        count.addAndGet(2);
        count.addAndGet(3);
        count.addAndGet(4);
        return count.get();
    }

    public static void main(String[] args) {
        final AtomicUse atomicUse = new AtomicUse();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threadList.add(new Thread(new RunThraed() {
                @Override
                public void run() {
                    System.out.println(atomicUse.mutilAdd());
                }
            }));
        }
        for (Thread thread : threadList) {
            thread.start();
        }

    }

}
