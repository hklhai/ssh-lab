package shiro.c5;

import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ocean lin on 2017/9/13.
 */
public class PasswordRetryTest extends BaseTest {

    public void testRetryLimitHashedCredentialsMatcherWithMyRealm() {
        for (int i = 1; i <= 6; i++) {
            try {
                login("classpath:shiro-retryLimitHashedCredentialsMatcher.ini", "liu", "234");
            } catch (ExcessiveAttemptsException e) {
                System.out.println("==================");
            } catch (IncorrectCredentialsException e) {
                System.out.println("+++++++++++++++++++");
            }
        }
    }

}
