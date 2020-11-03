package com.example.access_control.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Security;

@Slf4j
public class RedisSecurityContextRepository  implements SecurityContextRepository {

    public static final String HTTP_HEADER_TOKEN_KEY = "Authorization";

    private ValueOperations<String, Object> vop;
    private static final String KEY_STORE_SERVICE = "mipay_admin";
    private static final String KEY_TYPE = "token";

    public RedisSecurityContextRepository(RedisTemplate redisTemplate) {
        this.vop = redisTemplate.opsForValue();
    }

    @Override
    public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
        HttpServletRequest request = requestResponseHolder.getRequest();
        HttpServletResponse response = requestResponseHolder.getResponse();

        String token = request.getHeader(HTTP_HEADER_TOKEN_KEY);
        if (token == null) {
            if (log.isDebugEnabled()) {
                log.debug("No SecurityContext was available. A new one will be created.");
            }
            return new SecurityContextImpl();
        } else {
            SecurityContext context = readSecurityContextFromRepository(token);
            return context == null ? new SecurityContextImpl() : context;
        }
    }

    @Override
    public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
//        vop.set();
    }

    @Override
    public boolean containsContext(HttpServletRequest request) {
        String token = request.getHeader(HTTP_HEADER_TOKEN_KEY);
        Object contextFromToken = vop.get(getKey(token));

        if (contextFromToken == null || !(contextFromToken instanceof SecurityContext)) {
            return false;
        }

        return true;
    }

    private String getKey(String token) {
        return String.format("%s:%s:%s", KEY_STORE_SERVICE, KEY_TYPE, token).toString();
    }

    private SecurityContext readSecurityContextFromRepository(String token) {
        final boolean debug = log.isDebugEnabled();

        if (token == null) {
            if (debug) {
                log.debug("No Authorization User.");
            }

            return null;
        }

        // Token exists, so try to obtain a context from it.
        Object contextFromToken = vop.get(getKey(token));

        if (contextFromToken == null) {
            if (debug) {
                log.debug("Redis repository returned null object for key: {}", getKey(token));
            }

            return null;
        }

        // We now have the security context object from the session.
        if (!(contextFromToken instanceof SecurityContext)) {
            if (log.isWarnEnabled()) {
                log.warn(token
                        + " did not contain a SecurityContext but contained: '"
                        + contextFromToken
                        + "'; are you improperly modifying the data directly "
                        + "(you should always use SecurityContextHolder) or using the redis-set attribute "
                        + "reserved for this class?");
            }

            return null;
        }

        if (debug) {
            log.debug("Obtained a valid SecurityContext from "
                    + token + ": '" + contextFromToken + "'");
        }

        // Everything OK. The only non-null return from this method.

        return (SecurityContext) contextFromToken;
    }
}
