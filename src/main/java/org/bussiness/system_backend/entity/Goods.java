package org.bussiness.system_backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("a_goods")
public class Goods {

    private Integer id;

    private String name;

    private LocalDateTime createTime;

    private Integer isDelete;

}
