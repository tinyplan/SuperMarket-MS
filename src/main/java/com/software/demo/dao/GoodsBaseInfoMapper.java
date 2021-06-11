package com.software.demo.dao;

import com.software.demo.entity.po.GoodsBaseInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsBaseInfoMapper {

    int insertGoodsBaseInfo(GoodsBaseInfo baseInfo);

    int updateGoodsBaseInfo(GoodsBaseInfo newBaseInfo);

    GoodsBaseInfo queryGoodsBaseInfo(GoodsBaseInfo queryBaseInfo);

    List<GoodsBaseInfo> queryAllGoodsBaseInfo();


}
