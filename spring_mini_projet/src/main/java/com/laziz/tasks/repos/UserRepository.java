package com.laziz.tasks.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.laziz.tasks.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}