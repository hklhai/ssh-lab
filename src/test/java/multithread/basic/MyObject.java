package multithread.basic;

/**
 * Created by Ocean lin on 2017/9/6.
 */
public class MyObject {

    public synchronized void m1() {
        try {
            System.out.println(Thread.currentThread().getName());

            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //  如果不加synchronized修饰，m2()不需要获得锁定的MyObject对象
    public synchronized void m2() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        final MyObject myObject = new MyObject();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                myObject.m1();
            }
        }, "thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                myObject.m2();
            }
        }, "thread2");

        thread1.start();
        thread2.start();
    }

}
