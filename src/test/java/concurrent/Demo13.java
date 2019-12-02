package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ocean lin on 2019/12/1.
 *
 * @author Ocean lin
 */
public class Demo13 {

    volatile boolean flag = true;

    public void test() {
        System.out.println("test start");
        while (flag) {

        }
        System.out.println("test end");
    }


    public static void main(String[] args) {
        Demo13 demo13= new Demo13();
        new Thread(() -> demo13.test()).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        demo13.flag = false;

    }
}
