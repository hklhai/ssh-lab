package cn.edu.ncut.test;

import cn.edu.ncut.service.ProxyInvocationHandler;
import cn.edu.ncut.service.ProxyService;
import cn.edu.ncut.service.ProxyServiceImpl;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.lang.reflect.Proxy;

/**
 * Created by Ocean Lin on 2017/4/29.
 */
public class ProxyTest {

    @Test
    public void test() {

        ProxyService proxyServiceImpl = new ProxyServiceImpl();

        ClassLoader classLoader = ProxyTest.class.getClassLoader();
        //使用继承InvocationHandler的方法，将实现类传入
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler(new ProxyServiceImpl());
        ProxyService proxyService = (ProxyService) Proxy.newProxyInstance(classLoader, new Class<?>[]{ProxyService.class}, proxyInvocationHandler);


        System.out.println("new =========");
        proxyServiceImpl.save("nihao");
        System.out.println("new =========");
        proxyService.save("haha");
        generateProxyClass();
    }


    private void generateProxyClass() {
        byte[] proxy0s = ProxyGenerator.generateProxyClass("$Proxy0", new Class<?>[]{ProxyService.class});
        try {
            //FileOutputStream fileOutputStream = new FileOutputStream("$Proxy0.java");
            //fileOutputStream.write(proxy0s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("write success!");

    }


    @Test
    public void testStr() {
        String s = "互联网服务事业部-网校事业部-学习服务部-服务运营部-初中理科";


        String[]  str = new String[] {"互联网服务事业部-网校事业部-学习服务部-服务运营部-初中理科",
                "互联网服务事业部-网校事业部-学习服务部",
                "互联网服务事业部-网校事业部-学习服务部",
                "互联网服务事业部-网校事业部",
                "互联网服务事业部-网校事业部-学习服务部-服务运营部",
                "互联网服务事业部-网校事业部-学习服务部-服务运营部-初中理科-AAA"
        };
        for (int i = 0; i < str.length; i++) {
            getLastStrByLine(str[i]);
        }


    }

    private String getLastStrByLine(String s) {
        String[] split = s.split("-");
        System.out.println(split[split.length - 1]);
        return split[split.length - 1];
    }


}
