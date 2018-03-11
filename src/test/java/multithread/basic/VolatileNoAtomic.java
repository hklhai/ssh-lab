package multithread.basic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Ocean lin on 2017/9/12.
 */
public class VolatileNoAtomic extends Thread {

//    private static volatile int count = 0;
    private static AtomicInteger count= new AtomicInteger(0);
    @Override
    public void run() {
        addCount();
    }

    private static void addCount() {
        for(int i = 0;i<1000;i++)
        {
//            count++;
            count.incrementAndGet();
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        VolatileNoAtomic[] volatileNoAtomics = new VolatileNoAtomic[10];
        for(int j =0 ;j<10;j++)
        {
            volatileNoAtomics[j]=new VolatileNoAtomic();
        }
        for (int i = 0; i <10 ; i++) {
            volatileNoAtomics[i].start();
        }
    }
}
