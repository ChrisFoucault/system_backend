package org.bussiness.system_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.bussiness.system_backend.constants.JwtUtil;
import org.bussiness.system_backend.entity.User;
import org.bussiness.system_backend.exception.BusinessException;
import org.bussiness.system_backend.mapper.UserMapper;
import org.bussiness.system_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, Object> login(String username, String password) {
        if (!StringUtils.hasText(username) || !StringUtils.hasText(password)) {
            throw new BusinessException("用户名或密码不能为空");
        }

        String normalizedUsername = username.trim();
        User user = userMapper.findByUsername(normalizedUsername);
        if (user == null) {
            throw new BusinessException("用户不存在");
        }

        if (Integer.valueOf(1).equals(user.getIsDelete())) {
            throw new BusinessException("用户已被禁用");
        }

        if (!isPasswordValid(password, user.getPassword())) {
            throw new BusinessException("密码错误");
        }

        String token = JwtUtil.generateToken(username);

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

    @Override
    public void logout() {
        // Implement logout logic, e.g., invalidate session
    }
}
