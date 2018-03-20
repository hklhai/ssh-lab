package multithread.disrupt;


import com.lmax.disruptor.EventHandler;

/**
 * Created by Ocean lin on 2018/3/20.
 *
 * @author Ocean lin
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println(longEvent.getValue());
    }
}
