package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ocean lin on 2019/12/1.
 *
 * @author Ocean lin
 */
public class Demo8 {

    private String name;
    private double balance;

    public synchronized void set(String name, double balance) {
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public double getBalance(String name) {
        return this.balance;
    }


    public static void main(String[] args) {
        Demo8 demo8 = new Demo8();
        new Thread(() -> demo8.set("hk", 1000000.0)).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(demo8.getBalance("hk"));
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(demo8.getBalance("hk"));


    }

}
