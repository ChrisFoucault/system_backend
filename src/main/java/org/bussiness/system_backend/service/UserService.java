package org.bussiness.system_backend.service;

import java.util.Map;

public interface UserService {
    Map<String, Object> login(String username, String password);
    void logout();
}
