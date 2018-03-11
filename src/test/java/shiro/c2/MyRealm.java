package shiro.c2;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by Ocean lin on 2017/9/6.
 */
public class MyRealm implements Realm {


    @Override
    public String getName() {
        return "MyRealm";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
//        String credentials = (String) authenticationToken.getCredentials();
//        C cannot be cast to java.lang.String
        String credentials = new String((char[]) authenticationToken.getCredentials());
        if (!"zhang".equals(principal))
            throw new UnknownAccountException();
        if (!"123".equals(credentials))
            throw new IncorrectCredentialsException();

        return new SimpleAuthenticationInfo(principal, credentials, getName());
    }
}
