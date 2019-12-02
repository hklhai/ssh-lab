package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * 异常如果不处理会释放锁
 *
 * Created by Ocean lin on 2019/12/1.
 *
 * @author Ocean lin
 */
public class Demo11 {

    int count = 0;

    public synchronized void test() {
        System.out.println(" test1 start ");
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count: " + count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 5) {
                int i = 1 / 0;
            }
        }
    }


    public static void main(String[] args) {
        Demo11 demo11 = new Demo11();

        Runnable r = () -> demo11.test();
        new Thread(r, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(r, "t2").start();
    }
}