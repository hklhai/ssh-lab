package multithread.designpattern.futuredemo;

/**
 * Created by Ocean lin on 2018/3/14.
 *
 * @author Ocean lin
 */
public class Main {

    public static void main(String[] args) {
        FutureClient fc = new FutureClient();
        Data data = fc.request("request");
        System.out.println("请求发送成功!");
        System.out.println("do something");

        String request = data.getRequest();
        System.out.println(request);
    }
}
