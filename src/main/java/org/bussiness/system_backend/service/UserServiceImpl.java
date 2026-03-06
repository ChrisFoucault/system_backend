package org.bussiness.system_backend.service;

import org.bussiness.system_backend.mapper.UserMapper;
import org.bussiness.system_backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, Object> login(String username, String password) {
        if (!StringUtils.hasText(username) || !StringUtils.hasText(password)) {
            throw new IllegalArgumentException("用户名或密码不能为空");
        }

        String normalizedUsername = username.trim();
        User user = userDao.findByUsername(normalizedUsername);
        if (user == null) {
            throw new SecurityException("用户不存在");
        }

        if ("1".equals(user.getIsDelete())) {
            throw new SecurityException("用户已被禁用");
        }

        if (!isPasswordValid(password, user.getPassword())) {
            throw new SecurityException("密码错误");
        }

        String token = generateToken(user);

        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("id", user.getId());
        userInfo.put("username", user.getUsername());
        userInfo.put("realName", user.getRealName());

        Map<String, Object> result = new HashMap<>();
        result.put("token", token);
        result.put("expiresAt", LocalDateTime.now().plusHours(2));
        result.put("user", userInfo);
        return result;
    }

    private boolean isPasswordValid(String rawPassword, String storedPassword) {
        if (!StringUtils.hasText(storedPassword)) {
            return false;
        }
        try {
            return passwordEncoder.matches(rawPassword, storedPassword) || rawPassword.equals(storedPassword);
        } catch (Exception e) {
            return rawPassword.equals(storedPassword);
        }
    }

    private String generateToken(User user) {
        String raw = user.getId() + ":" + user.getUsername() + ":" + System.currentTimeMillis() + ":" + UUID.randomUUID();
        return Base64.getUrlEncoder().withoutPadding().encodeToString(raw.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void logout() {
        // Implement logout logic, e.g., invalidate session
    }
}
