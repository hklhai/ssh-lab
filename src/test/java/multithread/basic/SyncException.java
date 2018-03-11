package multithread.basic;

/**
 * Created by Ocean lin on 2017/9/8.
 */
public class SyncException {

    private int i = 0;

    public synchronized void operation() {
        while (true) {
            try {
                i++;
                Thread.sleep(100);

                System.out.println(Thread.currentThread().getName() + " i:" + i);
                if (i == 10) {
                    Integer.parseInt("a");
                }
            } catch (InterruptedException e) {
                System.out.println("i=" + i);

                e.printStackTrace();
//                throw  new RuntimeException();
//                continue;
            }
        }
    }

    public static void main(String[] args) {
        final SyncException syncException = new SyncException();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                syncException.operation();
            }
        });
        thread.start();
    }


}
