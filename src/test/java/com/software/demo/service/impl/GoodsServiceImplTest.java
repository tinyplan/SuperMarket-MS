package com.software.demo.service.impl;

import com.software.demo.entity.dto.RefundGoodsDTO;
import com.software.demo.entity.dto.SellGoodsDTO;
import com.software.demo.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author tinyplan
 * 2021/06/15
 */
@SpringBootTest
class GoodsServiceImplTest {

    @Resource(name = "goodsServiceImpl")
    private GoodsService goodsService;

    @Test
    void addGoodsBaseInfo() {

    }

    @Test
    void modifyGoodsInfo() {
    }

    @Test
    void importGoods() {
    }

    @Test
    void sellGoods() {
        SellGoodsDTO sellGoodsDTO = new SellGoodsDTO();
        sellGoodsDTO.setGoodsId("7312-20210612-12");
        sellGoodsDTO.setGoodsNum(10);
        goodsService.sellGoods(sellGoodsDTO);
    }

    @Test
    void refundGoods() {
        RefundGoodsDTO refundGoodsDTO = new RefundGoodsDTO();
        refundGoodsDTO.setRecordId("20210613-15");
        refundGoodsDTO.setGoodsId("7312-20210610-8");
        refundGoodsDTO.setGoodsNum(1);
        goodsService.refundGoods(refundGoodsDTO);
    }

    @Test
    void queryGoods() {
        System.out.println(goodsService.queryGoods(10));
    }

    @Test
    void queryFinanceSummary() {
    }
}