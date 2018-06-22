package realm;

import Entity.Blogger;
import Service.BloggerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2018/6/19.
 */
public class MyRealm extends AuthorizingRealm{

    @Resource
    private BloggerService bloggerService;

    /**
     * 为当前登录的用户授予角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String)getAvailablePrincipal(principalCollection);
        if(userName.equals("admin")){
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.addRole("admin");
            return  simpleAuthorizationInfo;
        }
        return null;
    }

    /**
     * 身份认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        Blogger blogger = bloggerService.getBloggerByName(username);

        if(blogger != null){
            SecurityUtils.getSubject().getSession().setAttribute("currentUser",blogger);
            System.out.println(blogger.getPassWord());
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(blogger.getUserName(),blogger.getPassWord(),"MyRealm");
            return authcInfo;
        }else{
            return null;
        }
    }
}
