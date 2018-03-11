package shiro.c2;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ocean lin on 2017/9/5.
 */
public class TestHelloWorld {


    @Test
    public void testHello() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        loginFunction(factory, "zhang", "123");
    }

    @Test
    public void testCustomRealm() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        loginFunction(factory, "zhang", "123");
    }

    @Test
    public void testCustomMultiRealm() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-multi-realm.ini");
        loginFunction(factory, "wang", "123");
    }

    @Test
    public void testJDBCRealm() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
        loginFunction(factory, "zhang", "123");
    }

    @Test
    public void testAllSuccessfulStrategyWithSuccess() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-authenticator-all-success.ini");
        loginFunction(factory, "zhang", "123");
        Subject subject = SecurityUtils.getSubject();
        //得到一个身份集合，其包含了Realm验证成功的身份信息
        PrincipalCollection principalCollections = subject.getPrincipals();
        Assert.assertEquals(2, principalCollections.asList().size());
        subject.logout();
    }


    private void loginFunction(Factory<SecurityManager> factory, String name, String passwd) {
        SecurityManager instance = factory.getInstance();
        SecurityUtils.setSecurityManager(instance);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, passwd);

        try {
            subject.login(token);
        } catch (AuthenticationException e) {

        }
//        Assert.assertEquals(true, subject.isAuthenticated());

    }

    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
    }

}
