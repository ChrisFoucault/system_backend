package org.bussiness.system_backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("a_menu")
public class Menu {

    private Integer id;
    private String name;
    private LocalDateTime createTime;
    private String code;
    private Integer isDeleted;
    private Integer menuType;

}
