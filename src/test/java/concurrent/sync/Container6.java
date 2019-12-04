package concurrent.sync;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 写一个固定容量的同步容器，拥有put和get方法，以及getCount方法
 * 能够支持两个生产者线程及10个消费者线程的阻塞调用
 *
 * <p>
 * Created by Ocean lin on 2019/12/4.
 *
 * @author Ocean lin
 */
public class Container6<T> {

    private final LinkedList<T> list = new LinkedList();
    private final Integer MAX = 10;
    private Integer count = 0;

    public synchronized void put(T t) {
        /**
         *
         * wait一般配合while使用
         *
         * 关键点：采用while不使用if
         * 当线程被唤醒后，需要先判断，再执行（如果使用if，第一个线程正常；其余线程可能出错）
         */
        while (list.size() == MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        list.add(t);
        count++;
        this.notifyAll();
    }


    public synchronized T get() {
        T t = null;
        while (list.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = list.removeFirst();
        count--;
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {

        Container6<String> container6 = new Container6<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(container6.get());
                }
            }, "consumer" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < 2; i++) {

            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    container6.put(Thread.currentThread().getName() + " " + j);
                }
            }, "producer" + i).start();
        }
    }
}
