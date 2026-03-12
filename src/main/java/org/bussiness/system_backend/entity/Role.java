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
@TableName("a_role")
public class Role {

    private Integer id;

    private String name;

    private LocalDateTime createTime;

    private Integer isDelete;

}
