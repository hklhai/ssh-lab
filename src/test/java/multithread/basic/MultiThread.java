package multithread.basic;

/**
 * Created by Ocean lin on 2017/9/6.
 */
public class MultiThread {

    private static int num = 0;

    private static synchronized void setNum(String s) {
        try {
            if (s.equals("a")) {
                num = 100;
                System.out.println("tag a");
                Thread.sleep(1000);
            }
            if (s.equals("b")) {
                num = 200;
                System.out.println("tag b");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("tag:" + s + " " + "Num:" + num);
    }

    // 在静态方法上加上synchronized关键字，表示锁定.class类，类一级别的锁(独占.class类)。
    public static void main(String[] args) {
//        varable 'm2' is accessed from within inner class, needs to be declared final

        final MultiThread m1 = new MultiThread();
        final MultiThread m2 = new MultiThread();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                m1.setNum("a");
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                m2.setNum("b");
            }
        });
        t1.start();
        t2.start();

    }

}
