package com.software.demo.service;

import com.software.demo.entity.dto.GoodsBaseInfoDTO;
import com.software.demo.entity.dto.ImportGoodsDTO;
import com.software.demo.entity.dto.ModifyGoodsDTO;
import com.software.demo.entity.dto.SellGoodsDTO;
import com.software.demo.entity.vo.GoodsVO;

import java.util.List;

/**
 * @author tinyplan
 * 2021/6/3
 */
public interface GoodsService {

    boolean addGoodsBaseInfo(GoodsBaseInfoDTO dto);

    boolean modifyGoodsInfo(ModifyGoodsDTO dto);

    boolean importGoods(ImportGoodsDTO dto);

    boolean sellGoods(SellGoodsDTO dto);

    List<GoodsVO> queryGoods(Integer limit);

}
