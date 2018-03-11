package multithread.basic;

/**
 * Created by Ocean lin on 2017/9/12.
 */
public class RunThraed extends Thread {

    //private Boolean isRunning = true;  不会终止
    private volatile Boolean isRunning = true; // 会终止

    public void setRunning(Boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        System.out.println("begin...");
        while (isRunning == true) {
            //..
        }
        System.out.println("stop...");
    }

    public static void main(String[] args) throws InterruptedException {
        RunThraed runThraed = new RunThraed();
        runThraed.start();
        Thread.sleep(1000);
        // 如果isRunning参数不使用关键字volatile修饰，那么主线程修改后RunThraed线程是不可见的
        runThraed.setRunning(false);
        System.out.println("isRunning is " + runThraed.isRunning);
    }

}
