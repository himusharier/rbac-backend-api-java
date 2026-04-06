package com.example.rbac.repository;

import com.example.rbac.model.ERole;
import com.example.rbac.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
