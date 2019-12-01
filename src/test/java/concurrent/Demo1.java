package concurrent;

/**
 * Created by Ocean lin on 2019/12/1.
 *
 * @author Ocean lin
 */
public class Demo1 {
    private int count = 10;
    private Object o = new Object();

    public void test() {
        synchronized (o) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count: " + count);
        }

    }


}
