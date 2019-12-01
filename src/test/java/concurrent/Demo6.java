package concurrent;

/**
 * Created by Ocean lin on 2019/12/1.
 *
 * @author Ocean lin
 */
public class Demo6 implements Runnable {
    private static int count = 10;

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count: " + count);
    }

    public static void main(String[] args) {
        Demo6 demo5 = new Demo6();
        for (int i = 0; i < 5; i++) {
            new Thread(demo5, "HEAD:" + i).start();
        }
    }
}
