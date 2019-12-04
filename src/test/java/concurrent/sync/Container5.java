package concurrent.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 容器add，size方法
 * 线程1添加10个元素到容器内，线程2实现监控元素的个数
 * 当个数为5时，线程2给出提示并结束线程2
 * <p>
 * latch 门栓
 * <p>
 * <p>
 * CountDownLatch 更多用于并发测试；比如让1万个线程await；然后再统一执行一个方法
 * <p>
 * Created by Ocean lin on 2019/12/4.
 *
 * @author Ocean lin
 */
@SuppressWarnings("Duplicates")
public class Container5 {

    // 无法保证多个线程之间的可见性
    volatile List list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }


    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Container5 container5 = new Container5();
        CountDownLatch latch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2 start!");
            if (container5.size() != 5) {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 end!");
        }, "t2").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                container5.add(new Object());
                System.out.println("add:" + i);

                if (i == 5) {
                    latch.countDown();
                    // 到0后 所有调用.await()就会解阻塞
                }

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

    }
}
