package com.example.backend1.repo;
import com.example.backend1.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo  extends JpaRepository<Role,Long> {
    Role findByName(String name);
}

