package concurrent;

/**
 * Created by Ocean lin on 2019/12/1.
 *
 * @author Ocean lin
 */
public class Demo2 {
    private int count = 10;

    public void test() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count: " + count);
        }

    }


}
