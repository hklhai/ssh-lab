package concurrent;

/**
 * Created by Ocean lin on 2019/12/1.
 *
 * @author Ocean lin
 */
public class Demo10Child extends Demo10 {

    @Override
    public synchronized void test1() {
        System.out.println("Demo10Child test1 start ");

        super.test1();

        System.out.println("Demo10Child test1 end ");

    }
}
