package multithread.disrupt;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * Created by Ocean lin on 2018/3/20.
 *
 * @author Ocean lin
 */
public class LongEventProducerWithTranslator {

    private final RingBuffer<LongEvent> ringBuffer;


    public LongEventProducerWithTranslator(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }


    private static final EventTranslatorOneArg<LongEvent, ByteBuffer> translator =
            new EventTranslatorOneArg<LongEvent, ByteBuffer>() {
                @Override
                public void translateTo(LongEvent longEvent, long l, ByteBuffer byteBuffer) {
                    longEvent.setValue(byteBuffer.getLong(0));
                }
            };

    public void onData(ByteBuffer byteBuffer) {
        ringBuffer.publishEvent(translator, byteBuffer);
    }
}
