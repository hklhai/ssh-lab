package multithread.queue;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Ocean lin on 2018/3/11.
 *
 * @author Ocean lin
 */
public class BlockQueue {
    // 集合
    private final LinkedList<Object> list = new LinkedList<>();

    // 计数器
    private AtomicInteger count = new AtomicInteger(0);

    // 上下限
    private final int miniSize = 0;
    private final int maxSize;

    public BlockQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    // 锁对象
    private final Object lock = new Object();


    public void put(Object o) {
        synchronized (lock) {
            while (count.get() == maxSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 增加元素，累加
                list.add(o);
                System.out.println("add:" + o);
                count.incrementAndGet();
                // 重点，要通知另外线程(唤醒)；比如有一个线程正在阻塞，等待获取元素
                lock.notify();
            }
        }
    }

    public Object take() {
        Object ret = null;
        synchronized (lock) {
            while (count.get() == miniSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ret = list.removeFirst();
            count.decrementAndGet();
            System.out.println("del:" + ret);
            // 唤醒可能正在被阻塞的线程
            lock.notify();
        }
        return ret;
    }
}
