package multithread.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ocean lin on 2018/3/13.
 *
 * @author Ocean lin
 */
public class QueueDemo {
    public static void main(String[] args) throws InterruptedException {
        //高性能无阻塞无界队列：ConcurrentLinkedQueue
        ConcurrentLinkedQueue<String> q = new ConcurrentLinkedQueue<>();
        q.offer("a");
        q.offer("b");
        q.offer("c");
        q.offer("d");
        q.add("e");

        System.out.println(q.poll());    //a 从头部取出元素，并从队列里删除
        System.out.println(q.size());    //4
        System.out.println(q.peek());    //b
        System.out.println(q.size());    //4


        System.out.println("====================================================");


        ArrayBlockingQueue<String> array = new ArrayBlockingQueue<>(5);
        array.put("a");
        array.put("b");
        array.add("c");
        array.add("d");
        array.add("e");
//        array.add("f");
        System.out.println(array.offer("a", 3, TimeUnit.SECONDS));

        System.out.println("====================================================");


        //阻塞队列
        LinkedBlockingQueue<String> x = new LinkedBlockingQueue<>();
        x.offer("a");
        x.offer("b");
        x.offer("c");
        x.offer("d");
        x.offer("e");
        x.add("f");
        //System.out.println(q.size());

//		for (Iterator iterator = q.iterator(); iterator.hasNext();) {
//			String string = (String) iterator.next();
//			System.out.println(string);
//		}

        List<String> list = new ArrayList<>();
        System.out.println(x.drainTo(list, 3));
        System.out.println(list.size());
        for (String string : list) {
            System.out.println(string);
        }

    }
}
