package study.proxybaisc.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Ocean lin on 2020/2/11.
 *
 * @author Ocean lin
 */
public class CustomInvocationHandler implements InvocationHandler {

    Object object;

    public CustomInvocationHandler(Object object) {
        this.object = object;
    }

    /**
     * @param proxy  代理对象
     * @param method 目标对象
     * @param args   目标对象参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before action!");

        Object invoke = method.invoke(object, args);

        System.out.println("after action!");
        return invoke;
    }
}
