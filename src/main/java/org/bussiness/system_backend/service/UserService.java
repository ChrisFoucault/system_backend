package org.bussiness.system_backend.service;

import org.bussiness.system_backend.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    Map<String, Object> login(String username, String password);

    /**
     * 登出
     * @return
     */
    void logout();
}
