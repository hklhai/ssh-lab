package org.dao;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * Created by Ocean lin on 2020/2/24.
 *
 * @author Ocean lin
 */

@Component("daoFactoryBean")
public class DaoFactoryBean implements FactoryBean {

    public void test() {
        System.out.println("DaoFactoryBean");
    }

    @Override
    public Object getObject() throws Exception {
        return new TempDaoFactoryBean();
    }

    @Override
    public Class<?> getObjectType() {
        return TempDaoFactoryBean.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
