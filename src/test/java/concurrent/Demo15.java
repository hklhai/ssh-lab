package concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ocean lin on 2019/12/1.
 *
 * @author Ocean lin
 */
public class Demo15 {
    volatile int count = 0;

    public synchronized void test() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        Demo15 demo14 = new Demo15();
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
