package org.annotation;

import org.spring.util.AnnotationConfigApplicationContext;

/**
 * Created by Ocean lin on 2020/2/25.
 *
 * @author Ocean lin
 */
public class AnnotationTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.service");
    }
}
