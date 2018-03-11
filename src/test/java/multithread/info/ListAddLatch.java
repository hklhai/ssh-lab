package multithread.info;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Ocean lin on 2017/9/14.
 */
public class ListAddLatch {

    private volatile static List list = new ArrayList();

    public void add() {
        list.add("haha");
    }

    public int size() {
        return list.size();
    }


    public static void main(String[] args) {

        final ListAddLatch listAdd = new ListAddLatch();

        //可以做到实时通知
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        //final CountDownLatch countDownLatch = new CountDownLatch(1);
        //发送两次countDownLatch.countDown();后才会调用thread2

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                    for (int i = 0; i < 10; i++) {
                        listAdd.add();
                        System.out.println("Current Thread " + Thread.currentThread().getName());
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (list.size() == 5) {
                            System.out.println("notify!");
                            countDownLatch.countDown();
                        }
                }
            }
        }, "thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                    if (list.size() != 5) {
                        try {
                            countDownLatch.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Receive notify Current Thread " + Thread.currentThread().getName());
                        throw new RuntimeException();
                }
            }
        }, "thread2");
        thread2.start();
        thread1.start();
        // thread2必须先执行，将锁释放，处于等待状态，否则thread1先获得锁，执行完后，释放锁
        // thread2获得thread1释放的锁后无法被唤醒， 阻塞在object.wait();无法使用
    }


}
