package concurrent.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 容器add，size方法
 * 线程1添加10个元素到容器内，线程2实现监控元素的个数
 * 当个数为5时，线程2给出提示并结束线程2
 * Created by Ocean lin on 2019/12/3.
 *
 * @author Ocean lin
 */
@SuppressWarnings("Duplicates")
public class Container2 {

    // 无法保证多个线程之间的可见性
    volatile List list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }


    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Container2 container2 = new Container2();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                container2.add(new Object());
                System.out.println("add:" + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "t1").start();

        new Thread(() -> {
            for (; ; ) {
                if (container2.size() == 5) {
                    break;
                }
            }
            System.out.println("t2 end!");
        }, "t2").start();

    }
}
