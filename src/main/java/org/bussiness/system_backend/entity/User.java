package org.bussiness.system_backend.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;

    private String username;

    private String password;

    private String realName;

    private LocalDateTime createTime;

    private Integer isDelete;

}
