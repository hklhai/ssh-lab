package org.spring.util;

import org.annotation.MyService;

import java.io.File;

/**
 * Created by Ocean lin on 2020/2/25.
 *
 * @author Ocean lin
 */
public class AnnotationConfigApplicationContext {

    public void scan(String basePackage) {
        String rootPath = this.getClass().getResource("/").getPath();
        String basePackagePath = basePackage.replaceAll("\\.", "\\\\");
        File file = new File(rootPath + "//" + basePackagePath);
        String names[] = file.list();
        for (String name : names) {
            name = name.replaceAll(".class", "");
            try {

                Class clazz = Class.forName(basePackage + "." + name);
                //判斷是否是屬於@servi@xxxx
                if (clazz.isAnnotationPresent(MyService.class)) {
                    MyService luban = (MyService) clazz.getAnnotation(MyService.class);
                    System.out.println(luban.value());
                    System.out.println(clazz.newInstance());

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


}
