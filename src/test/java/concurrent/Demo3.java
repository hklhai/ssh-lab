package concurrent;

/**
 * Created by Ocean lin on 2019/12/1.
 *
 * @author Ocean lin
 */
public class Demo3 {
    private int count = 10;

    public synchronized void test() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count: " + count);
    }



}
