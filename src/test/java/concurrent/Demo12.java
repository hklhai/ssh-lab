package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ocean lin on 2019/12/1.
 *
 * @author Ocean lin
 */
public class Demo12 {

    boolean flag = true;

    public void test() {
        System.out.println("test start");
        while (flag) {

        }
        System.out.println("test end");
    }


    public static void main(String[] args) {
        Demo12 demo12 = new Demo12();
        new Thread(() -> demo12.test()).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        demo12.flag = false;

    }
}
