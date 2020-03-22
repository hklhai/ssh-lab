package mylog.test;

import mylog.Appconfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Ocean lin on 2020/3/21.
 *
 * @author Ocean lin
 */
public class Test {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);

        context.start();
    }
}
