package multithread.designpattern.futuredemo;

/**
 * Created by Ocean lin on 2018/3/14.
 *
 * @author Ocean lin
 */
public class FutureClient {
    public Data request(final String queryString) {
        // 1 一个代理对象（Data接口的实现类）先返回给发送请求的客户端，告诉他请求已经接收到，可以做其他的事情
        final FutureData futureData = new FutureData();

        new Thread(new Runnable() {
            @Override
            public void run() {
                RealData realData = new RealData(queryString);
                futureData.setRealData(realData);
            }
        }).start();

        return futureData;
    }

}
