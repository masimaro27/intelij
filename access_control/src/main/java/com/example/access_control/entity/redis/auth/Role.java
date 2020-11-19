package com.example.access_control.entity.redis.auth;

import com.example.access_control.entity.AdmGroupPermission;
import com.example.access_control.entity.AdmOperGroup;
import com.example.access_control.exception.BusinessException;
import com.example.access_control.repository.redis.auth.RoleRedisRepository;
import com.example.access_control.utils.BeanUtils;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.security.Permissions;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Role")
public class Role implements Serializable {
    @Id
    private Long groupIdx;
    private String name;
    private List<Permission> permissions;

    public static Role generate(AdmOperGroup group) {
        List<Permission> pList = new ArrayList();
        for (AdmGroupPermission agp: group.getPermissions()) {
            pList.add(Permission.generate(agp));
        }

        return new Role(group.getDbIdx(), group.getGroupName(), pList);
    }
    public static void update(AdmGroupPermission agp) {
        Long groupIdx = agp.getAdmOperGroup().getDbIdx();
        String groupname = agp.getAdmOperGroup().getGroupName();
        RoleRedisRepository roleRedisRepo = (RoleRedisRepository) BeanUtils.getBean("roleRedisRepository");
        Role role = roleRedisRepo.findById(groupIdx).orElse(new Role(groupIdx, groupname, new ArrayList<>()));
        Permission findPermission =  role.getPermissions().stream()
                                                        .filter(p -> p.getMenuIdx() == agp.getSysMenu().getDbIdx())
                                                        .findAny()
                                                        .orElseThrow(() -> new BusinessException("SERVER_ERROR", "요청한 메뉴인덱스가 존재하지 않음."));
        role.getPermissions().remove(findPermission);
        role.getPermissions().add(findPermission.update(agp));
        roleRedisRepo.save(role);
    }

    public static void add(AdmGroupPermission agp) {
        Long groupIdx = agp.getAdmOperGroup().getDbIdx();
        String groupname = agp.getAdmOperGroup().getGroupName();
        RoleRedisRepository roleRedisRepo = (RoleRedisRepository) BeanUtils.getBean("roleRedisRepository");
        Role role = roleRedisRepo.findById(groupIdx).orElse(new Role(groupIdx, groupname, new ArrayList<>()));
        role.getPermissions().add(Permission.generate(agp));
        roleRedisRepo.save(role);
    }

    public static void delete(AdmGroupPermission agp) {
        Long groupIdx = agp.getAdmOperGroup().getDbIdx();
        String groupname = agp.getAdmOperGroup().getGroupName();
        RoleRedisRepository roleRedisRepo = (RoleRedisRepository) BeanUtils.getBean("roleRedisRepository");
        Role role = roleRedisRepo.findById(groupIdx).orElse(new Role(groupIdx, groupname, new ArrayList<>()));
    }

    public boolean hasPermission() {
        List<Permission> permissions = this.permissions;
        long pCount = permissions.stream().filter( p -> {
            Pattern pattern = Pattern.compile("([CRUD]|[crud])+");
            Matcher m = pattern.matcher(p.getActions());
            return m.find();
        }).count();

        return this.permissions.size() > 0 && pCount > 0;
    }
}
