package shiro.c2;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

/**
 * Created by Ocean lin on 2017/9/7.
 */
public class MyRealm2 implements Realm {
    @Override
    public String getName() {
        return "MyRealm2";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        String principal = (String) authenticationToken.getPrincipal();
//        Object credentials = new String((char[]) authenticationToken.getCredentials());
//        if (!"zhang".equals(principal))
//            throw new UnknownAccountException();
//        if (!"123".equals(credentials))
//            throw new IncorrectCredentialsException();
//        return new SimpleAuthenticationInfo(principal + "@163.com", credentials, getName());
        return null;
    }
}
