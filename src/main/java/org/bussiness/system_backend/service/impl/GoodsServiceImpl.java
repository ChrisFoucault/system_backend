package org.bussiness.system_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.bussiness.system_backend.constants.ConstantEnums;
import org.bussiness.system_backend.entity.Goods;
import org.bussiness.system_backend.mapper.GoodsMapper;
import org.bussiness.system_backend.service.GoodsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    private final GoodsMapper goodsMapper;

    public GoodsServiceImpl(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

}

