package org.bussiness.system_backend.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String realName;
    private LocalDateTime createTime;
    private String isDelete;
}
