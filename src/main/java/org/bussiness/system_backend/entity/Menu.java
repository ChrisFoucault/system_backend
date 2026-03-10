package org.bussiness.system_backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    private Integer id;

    private Integer parentId;

    private String name;

    private LocalDateTime createTime;

    private String code;

    private Integer isDeleted;

    private Integer menuType;

}
