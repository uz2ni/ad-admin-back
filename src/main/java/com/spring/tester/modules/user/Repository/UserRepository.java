package com.spring.tester.modules.user.Repository;

import com.spring.tester.modules.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}
