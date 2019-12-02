package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * 可重入锁
 * <p>
 * <p>
 * Created by Ocean lin on 2019/12/1.
 *
 * @author Ocean lin
 */
public class Demo10 {

    public synchronized void test1() {
        System.out.println("Demo10 test1 start ");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Demo10 test1 end ");
    }

    public static void main(String[] args) {
        Demo10Child child = new Demo10Child();
        new Thread(() -> child.test1()).start();

    }

}

