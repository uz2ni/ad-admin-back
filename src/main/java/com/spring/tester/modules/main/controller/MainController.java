package com.spring.tester.modules.main.controller;

import com.spring.tester.modules.user.Repository.UserRepository;
import com.spring.tester.modules.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/api/v1/main")
    public String getRoot() {
        return "mainTest";
    }

    @PostMapping("/api/v1/main")
    public String setAuth() {
        return "setAuth";
    }

    @PostMapping("join")
    public String join(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles("ROLE_USER");
        userRepository.save(user);

        System.out.println("users print");
        List<User> list = userRepository.findAll();
        for(User u : list) {
            System.out.println(u.toString());
        }

        return "회원가입 완료";
    }
}
