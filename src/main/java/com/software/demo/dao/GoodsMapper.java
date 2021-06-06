package com.software.demo.dao;

import com.software.demo.entity.domain.GoodsDO;
import com.software.demo.entity.po.Goods;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {

    Integer insertGoods(Goods goods);

    Integer deleteGoods(String id);

    Integer updateGoods(Goods goods);

    List<Goods> queryAllGoods();

    /**
     * 分页查询
     *
     * @param start 起始索引
     * @param limit 每页最大数量
     */
    List<GoodsDO> queryGoods(@Param("start") int start, @Param("limit") int limit);
}
