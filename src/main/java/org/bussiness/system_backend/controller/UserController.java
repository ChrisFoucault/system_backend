package org.bussiness.system_backend.controller;

import org.bussiness.system_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param username
     * @param password
     */
    public record LoginRequest(String username, String password) {}
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest request) {
        return userService.login(request.username(), request.password());
    }


    @PostMapping("/logout")
    public void logout() {
        userService.logout();
    }
}
