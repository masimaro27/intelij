package com.example.access_control.config.security;

import com.example.access_control.controller.TestController;
import com.example.access_control.entity.SysApi;
import com.example.access_control.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.expression.EvaluationContext;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.expression.ExpressionUtils;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class CustomAccessDecisonVoter implements AccessDecisionVoter<FilterInvocation>{
//    private SecurityExpressionHandler<FilterInvocation> expressionHandler = new DefaultWebSecurityExpressionHandler();

    private static final String CREATE = "C";
    private static final String READ = "R";
    private static final String UPDATE = "U";
    private static final String DELETE = "D";

    private ValueOperations<String, Object> vop;

    public CustomAccessDecisonVoter(RedisTemplate redisTemplate) {
        this.vop = redisTemplate.opsForValue();
    }


    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class clazz) {
        return true;
    }

    @Override
    public int vote(Authentication authentication, FilterInvocation fi, Collection attributes) {
        assert authentication != null;
        assert fi != null;
        assert attributes != null;

        if (isAnonymousUser(authentication)) {
            return ACCESS_ABSTAIN;
        }

        if (checkPermission( authentication.getAuthorities(), fi)) {
            return ACCESS_GRANTED;
        }
        return ACCESS_DENIED;
    }

    public boolean checkPermission(Collection<? extends GrantedAuthority> authorities, FilterInvocation fi) {
        String authUrl;
        String authActions;

        List<String[]> authDatas = authorities.stream()
                                .map(authority -> authority.getAuthority())
                                .map(authority -> authority.split(":"))
                                .collect(Collectors.toList());

        AntPathMatcher pathMatcher = new AntPathMatcher();
        String reqAction = convMethodToAction(fi.getHttpRequest().getMethod());

        if (!hasAuthData(authDatas)) {
            return false;
        }

        for (String[] authData: authDatas) {
            authUrl = authData[0];
            authActions = authData[1];
            if (pathMatcher.match(authUrl, fi.getRequestUrl())) {

                String[] sAuthActions = authActions.split(",");
                for (String authAction :sAuthActions) {
                    if (authAction.equals(reqAction)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public String convMethodToAction(String method) {
        switch(method) {
            case "POST":
                return CREATE;
            case "GET":
                return READ;
            case "PUT":
                return UPDATE;
            case "DELETE":
                return DELETE;
        }

        throw new BusinessException(
                "BAD REQUEST",
                "유효하지 않은 method 입니다."
        );
    }

    public boolean isAnonymousUser(Authentication authentication) {
        return "anonymousUser".equals(authentication.getPrincipal());
    }

    public boolean hasAuthData(List<String[]> authDatas) {
        return authDatas.size() == 2;
    }
}
