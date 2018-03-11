package multithread.basic;

/**
 * Created by Ocean lin on 2017/9/8.
 */
public class SyncExtend {

    static class Main {
        public int i = 10;

        public synchronized void operateSuper() {
            i--;
            System.out.println("Main print " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Sub extends Main {

        public synchronized void operateSub() {
            while (i > 0) {
                i--;
                System.out.println("Sub print " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.operateSuper();
            }
        }
    }

    public static void main(String[] args) {
        final Sub sub = new Sub();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sub.operateSub();
            }
        });
        t1.start();
    }


}
