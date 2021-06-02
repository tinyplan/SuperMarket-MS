package com.software.demo.dao;

import com.software.demo.entity.po.Goods;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsMapper {
    @Insert(" insert into goods_info (goods_id, goods_name, goods_type, goods_cost," +
            " goods_price, production_date, duration, expiration_date) values(#{id}, #{name}, #{type}, #{cost}," +
            " #{price}, #{productionDate}, #{duration}, #{expirationDate})")
    int insertGoods(Goods goods);

    @Update(" update goods_info set goods_name = #{name}, goods_type = #{type}, " +
            " goods_cost = #{cost}, goods_price = #{price}, production_date = #{productionDate}," +
            " duration = #{duration}, expiration_date = #{expirationDate} " +
            " where goods_id = #{id}")
    int updateGood(Goods goods);

    @Select(" select * from goods_info ")
    @Results(value = {
            @Result(column = "goods_id",property = "id",jdbcType = JdbcType.VARCHAR),
            @Result(column = "goods_name",property = "name"),
            @Result(column = "goods_type",property = "type"),
            @Result(column = "goods_cost",property = "cost",jdbcType = JdbcType.DECIMAL),
            @Result(column = "goods_price",property = "price",jdbcType = JdbcType.DECIMAL),
            @Result(column = "production_date",property = "productionDate"),
            @Result(column = "duration",property = "duration",jdbcType = JdbcType.INTEGER),
            @Result(column = "expiration_date",property = "expirationDate"),
    })
    List<Goods> selectAllGoods();

    @Delete(" delete from goods_info where goods_id = #{id}")
    int deleteGoods(String id);
}
