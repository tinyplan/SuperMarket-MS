package com.software.demo.dao;

import com.software.demo.entity.po.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {

    Integer insertGoods(Goods goods);

    Integer deleteGoods(@Param("id") String id);

    Integer updateGoods(Goods goods);

    Goods queryGoodsById(@Param("id") String id);

    /**
     * 分页查询
     *
     * @param start 起始索引
     * @param limit 每页最大数量
     */
    List<Goods> queryGoods(@Param("start") int start, @Param("limit") int limit);

    List<Goods> queryAllGoods();

}
