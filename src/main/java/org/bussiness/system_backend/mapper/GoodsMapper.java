package org.bussiness.system_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.bussiness.system_backend.entity.Goods;

import java.util.List;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
}

