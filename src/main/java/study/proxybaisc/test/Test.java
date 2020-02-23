package study.proxybaisc.test;


import study.proxybaisc.dao.LubanDao;
import study.proxybaisc.dao.LubanDaoImpl;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {

//        LubanDao proxy = (LubanDao) ProxyUtil.newInstance(new LubanDaoImpl());
//        proxy.query();

        LubanDao jdkProxy = (LubanDao) Proxy.newProxyInstance(Test.class.getClassLoader(),
                new Class[]{LubanDao.class}, new CustomInvocationHandler(new LubanDaoImpl()));
        jdkProxy.query();

    }
}
