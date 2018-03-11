package multithread;

/**
 * Created by Ocean lin on 2018/3/11.
 *
 * @author Ocean lin
 */
public class InnerSingleton {

    private static class Singletion {
        private static Singletion singletion = new Singletion();
    }

    public static Singletion getInstance() {
        return Singletion.singletion;
    }

}
