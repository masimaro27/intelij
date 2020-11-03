package com.example.access_control.controller;

import com.example.access_control.entity.AdmOperator;
import com.example.access_control.exception.BusinessException;
import com.example.access_control.repository.admOperGroup.AdmOperGroupRepository;
import com.example.access_control.repository.admOperator.AdmOperatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    public static Map<String, SecurityContext> test = new HashMap<>();

    private AdmOperatorRepository aor;
    private AdmOperGroupRepository aogr;
    private PasswordEncoder encoder;
    private AuthenticationManager authManager;
    private ValueOperations<String, Object> vop;

    @Autowired
    public TestController(AdmOperGroupRepository aogr,
                          AdmOperatorRepository aor,
                          PasswordEncoder encoder,
                          AuthenticationManager authManager,
                          RedisTemplate redisTemplate
    ) {
        this.aogr = aogr;
        this.aor = aor;
        this.encoder = encoder;
        this.authManager = authManager;
        this.vop = redisTemplate.opsForValue();
    }

    @GetMapping(value = "/login")
    public void login(@RequestParam("id") String id, @RequestParam("pw") String password) {
        AdmOperator ao = aor.findByManagerId(id).orElseThrow(() -> new BusinessException("NOT_FOUND", "일치하는 계정이 없습니다."));
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(id, password);
        try {
            Authentication authentication = authManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // TODO: redis 모듈로 분리
            // redis key 생성 로직
            // key pattern = location:type:key
            String generationToken = "token";
            String loc = "mipay_admin";
            String type = "token";
            String key = String.format("%s:%s:%s", loc, type, generationToken).toString();
            //
            //TODO: redis 모듈로 분리
            vop.set(key, SecurityContextHolder.getContext());
            //
        } catch (AuthenticationException ae) {
            ae.printStackTrace();
            throw new BusinessException("AUTHENTICATION_FAILED", "로그인 실패");
        }
    }

    @GetMapping(value = "/join")
    public void join(@RequestParam("id") String id, @RequestParam("pw") String password) {
        aor.save(
            AdmOperator.builder()
                    .managerId(id)
                    .password(encoder.encode(password))
                    .build());
    }

    @GetMapping(value = "/test")
    public void test() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        for (GrantedAuthority authority: authentication.getAuthorities()) {
            System.out.println(authority.getAuthority());
        }

        throw new BusinessException(
                "BAD REQUEST",
                "유효하지 않은 method 입니다."
        );
    }
}
