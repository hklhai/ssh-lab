package multithread.basic;

/**
 * 设置值需要较长时间，在未完成设置值期间，读的进程进入后读取了未设置值之前的结果
 *
 * Created by Ocean lin on 2017/9/7.
 */
public class DirtyRead {

    private String name = "Alex";
    private String password = "123";

    public synchronized void setValue(String name, String password) {
        this.name = name;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.password = password;
        System.out.println("SetValue name= " + name + "," + "password=" + password);
    }

    public synchronized void getValue() {
        System.out.println("GetValue name= " + this.name + "," + "password=" + this.password);
    }

    public static void main(String[] args) throws InterruptedException {
        final DirtyRead dirtyRead = new DirtyRead();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                dirtyRead.setValue("Lee", "456");  // 线程1
            }
        });

        t1.start();
        Thread.sleep(1000);
        dirtyRead.getValue();    // 线程2
    }

}
