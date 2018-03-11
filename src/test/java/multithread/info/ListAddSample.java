package multithread.info;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ocean lin on 2017/9/12.
 */
public class ListAddSample {
    private volatile static List list = new ArrayList();

    public void add() {
        list.add("haha");
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        final ListAddSample listAddSample = new ListAddSample();

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    listAddSample.add();
                    System.out.println("Current Thread " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (list.size() == 5) {
                        System.out.println("list size =5 " + Thread.currentThread().getName());
                        throw new RuntimeException();
                    }
                }
            }
        }, "t2");
        thread1.start();
        thread2.start();
    }


}
