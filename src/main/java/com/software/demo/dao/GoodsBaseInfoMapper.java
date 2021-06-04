package com.software.demo.dao;

import com.software.demo.entity.po.GoodsBaseInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GoodsBaseInfoMapper {
    @Insert(" insert into goods_base_info (goods_base_id, goods_name, goods_type )" +
            " values( #{goods_base_id}, #{goods_name}, #{goods_type})")
    int insertGoodsBaseInfo(GoodsBaseInfo baseInfo);

    @Select(" select * from goods_base_info where goods_base_id = #{goods_base_id}")
    GoodsBaseInfo selectGoodsBaseInfo(String goods_base_id);

    @Update(" update goods_base_info set goods_base_id = #{newBaseInfo.goods_base_id}, goods_name = #{newBaseInfo.goods_name}, goods_type = #{newBaseInfo.goods_type}" +
            " where goods_base_id = #{origin_base_id}")
    int updateGoodsBaseInfo(String origin_base_id,GoodsBaseInfo newBaseInfo);
}
