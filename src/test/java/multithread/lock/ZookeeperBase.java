package multithread.lock;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Ocean lin on 2018/3/18.
 *
 * @author Ocean lin
 */
public class ZookeeperBase {

    private static final String CONNECT_ADDR = "192.168.1.1";
    // ms
    private static final int SESSION_TIMEOUT = 5000;
    private static final CountDownLatch connectedSemaphore = new CountDownLatch(1);


    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper(CONNECT_ADDR, SESSION_TIMEOUT, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                Event.KeeperState state = watchedEvent.getState();
                Event.EventType type = watchedEvent.getType();

                if (Event.KeeperState.SyncConnected == state) {
                    if (Event.EventType.None == type) {
                        connectedSemaphore.countDown();
                        System.out.println("Zookeeper 连接建立。");
                    }
                }

            }
        }
        );

        // 进行阻塞
        connectedSemaphore.await();
    }
}
