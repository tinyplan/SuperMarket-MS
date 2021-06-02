package com.software.demo.dao;

import com.software.demo.entity.po.Imports;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ImportMapper {
    @Insert(" insert into import (import_id, goods_base_id, import_date, import_goods_sum )" +
            " values( #{import_id}, #{goods_base_id}, #{import_date}, #{import_goods_sum} )")
    int insertImport(Imports imports);

    @Select(" select * from import where import_goods_sum > 0")
    List<Imports> getAllImports();

    @Update(" update import set import_goods_sum = #{import_goods_sum} " +
            " where import_id = #{import_id} and goods_base_id = #{goods_base_id}")
    boolean updateImport(String import_id,String goods_base_id,int import_goods_sum);
}
