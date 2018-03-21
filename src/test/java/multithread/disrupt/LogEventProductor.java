package multithread.disrupt;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * Created by Ocean lin on 2018/3/20.
 *
 * @author Ocean lin
 */
public class LogEventProductor {

    private final RingBuffer<LongEvent> ringBuffer;

    public LogEventProductor(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    // 必须遵循4个步骤
    public void onData(ByteBuffer bb) {
        long sequeue = ringBuffer.next();
        try {
            LongEvent longEvent = ringBuffer.get(sequeue);
            longEvent.setValue(bb.getLong(0));
        } finally {
            ringBuffer.publish(sequeue);
        }
    }


}
