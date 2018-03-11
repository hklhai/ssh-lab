package multithread.info;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ocean lin on 2017/9/14.
 */
public class ListAdd {

    private volatile static List list = new ArrayList();

    public void add() {
        list.add("haha");
    }

    public int size() {
        return list.size();
    }


    public static void main(String[] args) {

        final ListAdd listAdd = new ListAdd();

        //使用wait和notify时，一定要配合synchronized关键字使用
        final Object object = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    for (int i = 0; i < 10; i++) {
                        listAdd.add();
                        System.out.println("Current Thread " + Thread.currentThread().getName());
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (list.size() == 5) {
                            System.out.println("notify!");//并不释放锁，线程结束后才释放锁
                            object.notify(); //与wait必须是统一对象
                        }
                    }
                }
            }
        }, "thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    if (list.size() != 5) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Receive notify Current Thread " + Thread.currentThread().getName());
                        throw new RuntimeException();
                    }
                }
            }
        }, "thread2");
        thread2.start();
        thread1.start();
        // thread2必须先执行，将锁释放，处于等待状态，否则thread1先获得锁，执行完后，释放锁
        // thread2获得thread1释放的锁后无法被唤醒， 阻塞在object.wait();无法使用
    }

}
