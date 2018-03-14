package multithread.queue;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by Ocean lin on 2018/3/14.
 * <p>
 * SynchronousQueue直接加入元素会报错，因为没有存储空间，
 * 需要直接连接消费端，增加的数据直接消费处理掉
 *
 * @author Ocean lin
 */
public class UseSynchronousQueue {

    public static void main(String[] args) {

        final SynchronousQueue<String> q = new SynchronousQueue<>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(q.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                q.add("asdasd");
            }
        });
        t2.start();
    }
}
