package concurrent;

/**
 * Created by Ocean lin on 2019/12/1.
 *
 * @author Ocean lin
 */
public class Demo4 {
    private static int count = 10;

    /**
     * 锁定的是类本身，不是new出来的对象
     */
    public synchronized static void test() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count: " + count);
    }

    public static void test2() {
        // 不能替换成this，静态的方法不能被new，所以那不到this
        synchronized (Demo4.class) {
            count--;
        }
    }

}
