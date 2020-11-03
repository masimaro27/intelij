package com.example.access_control.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.Assert;

@Data
public class CustomGrantedAuthority implements GrantedAuthority {
    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private final String url;
    private final String permission;

    public CustomGrantedAuthority(String url, String permission) {
        Assert.hasText(url, "A granted authority textual representation is required");
        Assert.hasText(permission, "A granted authority textual representation is required");
        this.url = url;
        this.permission = permission;
    }

    @Override
    public String getAuthority() {
        return String.format("%s:%s", url, permission);
    }


}
