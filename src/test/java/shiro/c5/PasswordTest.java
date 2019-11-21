package shiro.c5;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ocean lin on 2017/9/13.
 */
public class PasswordTest extends BaseTest {

    public void testPasswordServiceWithMyRealm() {
        //login("classpath:shiro-passwordservice.ini", "alex", "123");
        login("classpath:shiro-passwordservice.ini", "alex", "123");
        Assert.assertEquals(true, subject().isAuthenticated());
    }

    public void testPasswordServiceWithJdbcRealm()
    {
        login("classpath:shiro-jdbc-passwordservice.ini", "wu", "123");
        Assert.assertEquals(true, subject().isAuthenticated());
    }




}
