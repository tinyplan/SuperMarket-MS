package com.software.demo.service.impl;

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
    }

    @Test
    void refundGoods() {
    }

    @Test
    void queryGoods() {
        System.out.println(goodsService.queryGoods(10));
    }

    @Test
    void queryFinanceSummary() {
    }
}