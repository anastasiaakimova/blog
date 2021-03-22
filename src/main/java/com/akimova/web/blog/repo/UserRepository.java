package com.akimova.web.blog.repo;

import com.akimova.web.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
    //метод возвращает пользователя
    User findByUsername(String username);
}
