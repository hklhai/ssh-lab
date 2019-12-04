package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 单次调用属于原子操作
 * <p>
 * 但是多次调用不具备原子性
 * <p>
 * Created by Ocean lin on 2019/12/1.
 *
 * @author Ocean lin
 */
public class Demo16 {
    volatile AtomicInteger count = new AtomicInteger(0);

    public void test() {
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        Demo16 demo14 = new Demo16();
        List<Thread> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list.add(new Thread(demo14::test, "thread" + i));
        }
        list.forEach(e -> e.start());


        // 所有线程执行完毕
        list.forEach(e -> {
            try {
                e.join();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });


        System.out.println(demo14.count);
    }
}
