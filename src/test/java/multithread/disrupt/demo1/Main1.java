package multithread.disrupt.demo1;

import com.lmax.disruptor.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Ocean lin on 2018/3/21.
 *
 * @author Ocean lin
 */
public class Main1 {

    public static void main(String[] args) {
        int BUFFER_SIZE = 1024;
        int THREAD_NUMBERS = 4;

        /*
         * createSingleProducer创建一个单生产者的RingBuffer，
         * 第一个参数叫EventFactory，从名字上理解就是"事件工厂"，其实它的职责就是产生数据填充RingBuffer的区块。
         * 第二个参数是RingBuffer的大小，它必须是2的指数倍 目的是为了将求模运算转为&运算提高效率
         * 第三个参数是RingBuffer的生产都在没有可用区块的时候(可能是消费者（或者说是事件处理器） 太慢了)的等待策略
         */
        RingBuffer<Trade> ringBuffer = RingBuffer.createSingleProducer(new EventFactory<Trade>() {
            @Override
            public Trade newInstance() {
                return new Trade();
            }
        }, BUFFER_SIZE, new YieldingWaitStrategy());

        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUMBERS);

        // 创建SequenceBarrier
        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();

        // 创建消息处理器
        BatchEventProcessor<Trade> tradeProcessor = new BatchEventProcessor<Trade>(
                ringBuffer, sequenceBarrier, new TradeHandler());

        // 把消费者的位置信息引用注入到生产者    如果只有一个消费者的情况可以省略
        ringBuffer.addGatingSequences(tradeProcessor.getSequence());

        // 把消息处理器提交到线程池
        executor.submit(tradeProcessor);




    }
}
;