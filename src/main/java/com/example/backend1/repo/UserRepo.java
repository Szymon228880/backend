package com.example.backend1.repo;

import com.example.backend1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
