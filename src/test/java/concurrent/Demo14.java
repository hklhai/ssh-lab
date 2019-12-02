package concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile可见性，不保证原子性
 *
 * Created by Ocean lin on 2019/12/1.
 *
 * @author Ocean lin
 */
public class Demo14 {
    volatile int count = 0;

    public void test() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        Demo14 demo14 = new Demo14();
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
