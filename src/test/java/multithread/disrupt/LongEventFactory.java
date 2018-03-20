package multithread.disrupt;

import com.lmax.disruptor.EventFactory;

/**
 * Created by Ocean lin on 2018/3/20.
 *
 * @author Ocean lin
 */
public class LongEventFactory implements EventFactory {

    @Override
    public Object newInstance() {
        return new LongEvent();
    }
}
