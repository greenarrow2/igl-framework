package com.igl.gov.shrio.config;

import com.igl.gov.shrio.custom.StatelessAccessControlFilter;
import com.igl.gov.shrio.custom.StatelessAuthorizingRealm;
import com.igl.gov.shrio.factory.StatelessDefaultSubjectFactory;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {

    /**
     * 工厂过滤器创建
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean filterFactoryBean(SecurityManager securityManager) {

        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        filterFactoryBean.getFilters().put("statelessAuthc",statelessAuthcFilter());
        //拦截器
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/**", "statelessAuthc");
        filterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return filterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setSubjectFactory(subjectFactory());
        securityManager.setSessionManager(sessionManager());
        securityManager.setRealm(statelessRealm());
        /*
         * 禁用使用Sessions 作为存储策略的实现，但它没有完全地禁用Sessions
         * 所以需要配合context.setSessionCreationEnabled(false);
         */
        DefaultSubjectDAO subjectDAO = (DefaultSubjectDAO) securityManager.getSubjectDAO();
        DefaultSessionStorageEvaluator sessionStorageEvaluator = (DefaultSessionStorageEvaluator) subjectDAO.getSessionStorageEvaluator();
        sessionStorageEvaluator.setSessionStorageEnabled(false);
        return securityManager;
    }

    @Bean
    public DefaultWebSubjectFactory subjectFactory() {
        StatelessDefaultSubjectFactory subjectFactory = new StatelessDefaultSubjectFactory();
        return subjectFactory;
    }

    @Bean
    public DefaultSessionManager sessionManager() {
        DefaultSessionManager sessionManager = new DefaultSessionManager();
        sessionManager.setSessionValidationSchedulerEnabled(false);
        return sessionManager;
    }
    @Bean
    public StatelessAuthorizingRealm statelessRealm(){
        StatelessAuthorizingRealm  realm = new StatelessAuthorizingRealm();
         return realm;
    }

    /**
     * Add.4.1
     * 访问控制器.
     * @return
     */
    @Bean
    public StatelessAccessControlFilter statelessAuthcFilter(){
        StatelessAccessControlFilter statelessAuthcFilter = new StatelessAccessControlFilter();
        return statelessAuthcFilter;
    }

    /**
     * Add.5.1
     *  开启shiro aop注解支持.
     *  使用代理方式;所以需要开启代码支持;
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * Add.5.2
     *   自动代理所有的advisor:
     *   由Advisor决定对哪些类的方法进行AOP代理。
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }

}
