package concurrent.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 容器add，size方法
 * 线程1添加10个元素到容器内，线程2实现监控元素的个数
 * 当个数为5时，线程2给出提示并结束线程2
 * <p>
 * <p>
 * wait notify 一定要配合synchronized 使用
 * <p>
 * <p>
 * Created by Ocean lin on 2019/12/3.
 *
 * @author Ocean lin
 */
@SuppressWarnings("Duplicates")
public class Container3 {

    // 无法保证多个线程之间的可见性
    volatile List list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }


    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Container3 container3 = new Container3();
        Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2 start!");
                if (container3.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 end!");
                lock.notify();
            }
        }, "t2").start();


        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    container3.add(new Object());
                    System.out.println("add:" + i);

                    if (i == 5) {
                        lock.notify();

                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1").start();

    }
}
