package com.example.access_control.config.security;

import com.example.access_control.entity.AdmOperator;
import com.example.access_control.repository.admOperator.AdmOperatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final AdmOperatorRepository aor;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdmOperator ao = aor.findByManagerId(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return new CustomUserDetails(ao.getManagerId(), ao.getPassword(), ao.getAuthorities());
    }
}
