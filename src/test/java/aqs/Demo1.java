package aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by Ocean lin on 2019/12/3.
 *
 * @author Ocean lin
 */
public class Demo1 {


    public static void main(String[] args) {
        System.out.println("m1 ==========");

        Thread t1 = new Thread(() -> {
            System.out.println("t1 ==========");
            LockSupport.park();
            System.out.println("t2 ==========");
        }, "t1");
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("m2 ==========");
        LockSupport.unpark(t1);

    }
}
