package com.example.access_control.repository.redis.auth;

import com.example.access_control.entity.redis.auth.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRedisRepository extends CrudRepository<Role, Long> {
    Optional<Role> findById(Long id);
}
