package com.springboot.springsec.repo;

import com.springboot.springsec.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
