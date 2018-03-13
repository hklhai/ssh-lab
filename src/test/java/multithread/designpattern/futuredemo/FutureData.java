package multithread.designpattern.futuredemo;

/**
 * Created by Ocean lin on 2018/3/14.
 *
 * @author Ocean lin
 */
public class FutureData implements Data {

    private RealData realData;

    private boolean isReady = false;

    public synchronized void setRealData(RealData realData) {
        // 如果已经装载完毕了，就直接返回
        if(isReady){
            return;
        }

        this.realData=realData;
        isReady = true;
        // 通知装载完毕，getRequest可以返回了
        notify();
    }


    @Override
    public synchronized String getRequest() {
        // 如果没装载好 程序就一直处于阻塞状态
        // notify();后执行return方法返回真实数据
        while(!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.realData.getRequest();
    }
}
