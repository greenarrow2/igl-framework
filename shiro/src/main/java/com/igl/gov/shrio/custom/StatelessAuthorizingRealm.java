package com.igl.gov.shrio.custom;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class StatelessAuthorizingRealm extends AuthorizingRealm {
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof StatelessAuthenticationToken;
    }

    /**
     * 身份验证
     */
    @Override
    protected   AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{
        System.out.println("StatelessRealm.doGetAuthenticationInfo()");

        StatelessAuthenticationToken statelessToken =(StatelessAuthenticationToken)token;
        String username = (String)statelessToken.getPrincipal();//不能为null,否则会报错的.

        //根据用户名获取密钥（和客户端的一样）
        String key = getKey(username);

        //在服务器端生成客户端参数消息摘要
        String serverDigest = HmacSHA256Utils.digest(key, statelessToken.getParams());


        System.out.println(serverDigest+"," + statelessToken.getCredentials());
        //然后进行客户端消息摘要和服务器端消息摘要的匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                username,
                serverDigest,
                getName());
        return authenticationInfo;
    }

    /**
     * 授权
     */
    @Override
    protected   AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("StatelessRealm.doGetAuthorizationInfo()");
        //根据用户名查找角色，请根据需求实现
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        //这里模拟admin账号才有role的权限.
        if("admin".equals(username)){
            authorizationInfo.addRole("admin");
        }
        return authorizationInfo;
    }

    //得到密钥，此处硬编码一个.
    private String getKey(String username) {
        if("admin".equals(username)) {
            return "dadadswdewq2ewdwqdwadsadasd";
        }
        return null;
    }
}
