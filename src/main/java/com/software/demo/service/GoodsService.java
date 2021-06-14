package com.software.demo.service;

import com.software.demo.entity.dto.*;
import com.software.demo.entity.vo.FinanceSummaryVO;
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

    boolean refundGoods(RefundGoodsDTO dto);

    List<GoodsVO> queryGoods(Integer limit);

    List<FinanceSummaryVO> queryFinanceSummary(String type);

}
