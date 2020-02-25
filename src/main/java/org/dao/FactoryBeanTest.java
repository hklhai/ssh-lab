package org.dao;

import org.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Ocean lin on 2020/2/24.
 *
 * @author Ocean lin
 */
public class FactoryBeanTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TempDaoFactoryBean bean = (TempDaoFactoryBean)context.getBean("daoFactoryBean");
        bean.test();

        DaoFactoryBean daoFactoryBean = (DaoFactoryBean)context.getBean("&daoFactoryBean");
        daoFactoryBean.test();

    }

}
