package multithread.queue.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Ocean lin on 2018/3/17.
 *
 * @author Ocean lin
 */
public class UseUnBoundThreadLocalPoll implements Runnable {

    private static AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            int temp = count.incrementAndGet();
            System.out.println("任务" + temp);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * LinkedBlockingDeque每次仅能执行5个
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //System.out.println(Runtime.getRuntime().availableProcessors());
//        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);
        BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();


        ExecutorService executor = new ThreadPoolExecutor(
                5,        //core
                10,    //max
                120L,    //2fenzhong
                TimeUnit.SECONDS,
                queue);

        for (int i = 0; i < 20; i++) {
            executor.execute(new UseUnBoundThreadLocalPoll());
        }
        Thread.sleep(1000);
        System.out.println("queue size:" + queue.size());        //10
        Thread.sleep(2000);
    }
}
