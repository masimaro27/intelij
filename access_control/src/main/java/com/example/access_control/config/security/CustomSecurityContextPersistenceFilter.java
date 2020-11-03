package com.example.access_control.config.security;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CustomSecurityContextPersistenceFilter extends GenericFilterBean {

    static final String FILTER_APPLIED = "__spring_security_scpf_applied";

    private SecurityContextRepository repo;

    private boolean forceEagerSessionCreation = false;

    public CustomSecurityContextPersistenceFilter(RedisTemplate redisTemplate) {
        this(new RedisSecurityContextRepository(redisTemplate));
    }

    public CustomSecurityContextPersistenceFilter(SecurityContextRepository repo) {
        this.repo = repo;
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        final boolean debug = logger.isDebugEnabled();

        request.setAttribute(FILTER_APPLIED, Boolean.TRUE);

        HttpRequestResponseHolder holder = new HttpRequestResponseHolder(request, response);
        SecurityContext contextBeforeChainExecution = repo.loadContext(holder);

        try {
            SecurityContextHolder.setContext(contextBeforeChainExecution);

            chain.doFilter(holder.getRequest(), holder.getResponse());

        } finally {
//            SecurityContext contextAfterChainExecution = SecurityContextHolder.getContext();
//            // Crucial removal of SecurityContextHolder contents - do this before anything
//            // else.
//            SecurityContextHolder.clearContext();
//            repo.saveContext(contextAfterChainExecution, holder.getRequest(), holder.getResponse());
//            request.removeAttribute(FILTER_APPLIED);
//
//            if (debug) {
//                logger.debug("SecurityContextHolder now cleared, as request processing completed");
//            }
        }
    }

    public void setForceEagerSessionCreation(boolean forceEagerSessionCreation) {
        this.forceEagerSessionCreation = forceEagerSessionCreation;
    }
}
