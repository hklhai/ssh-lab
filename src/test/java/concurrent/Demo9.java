package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * 可重入锁
 * <p>
 * 一个同步方法调用另外一个同步方法是否能获取锁；
 *
 * 锁住的是堆内的同一个对象
 * <p>
 * Created by Ocean lin on 2019/12/1.
 *
 * @author Ocean lin
 */
public class Demo9 {

    public synchronized void test1() {
        System.out.println(" test1 start ");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test2();
    }

    public synchronized void test2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" test2 end ");
    }

    public static void main(String[] args) {
        Demo9 demo9 = new Demo9();
        new Thread(() -> demo9.test1()).start();
    }

}
