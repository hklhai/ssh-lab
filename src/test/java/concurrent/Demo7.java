package concurrent;

/**
 * 同步方法和非同步方法是否可以同时调用？ 可以
 * <p>
 * Created by Ocean lin on 2019/12/1.
 *
 * @author Ocean lin
 */
public class Demo7 {

    public synchronized void test1() {
        System.out.println(Thread.currentThread().getName() + " test1 start ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " test1 end ");
    }


    public void test2() {
        System.out.println(Thread.currentThread().getName() + " test2 start ");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " test2 end ");
    }


    public static void main(String[] args) {
        Demo7 demo7 = new Demo7();
        new Thread(demo7::test1, "test1").start();
        new Thread(demo7::test2, "test2").start();

    }

}
