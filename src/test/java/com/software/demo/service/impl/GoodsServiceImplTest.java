package com.software.demo.service.impl;

import com.software.demo.entity.dto.GoodsBaseInfoDTO;
import com.software.demo.entity.dto.ImportGoodsDTO;
import com.software.demo.entity.dto.ModifyGoodsDTO;
import com.software.demo.entity.vo.FinanceSummaryVO;
import com.software.demo.entity.vo.GoodsVO;
import com.software.demo.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

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
        GoodsBaseInfoDTO dto = new GoodsBaseInfoDTO();
        dto.setName("小熊饼干3");
        dto.setType("视频");
        goodsService.addGoodsBaseInfo(dto);
    }

    @Test
    void modifyGoodsInfo() {
        ModifyGoodsDTO dto = new ModifyGoodsDTO();
        dto.setGoodsId("7312-20210614-0");
        dto.setGoodsPrice(10.3F);
        dto.setStock(10);
        goodsService.modifyGoodsInfo(dto);
    }

    @Test
    void importGoods() {
        ImportGoodsDTO dto = new ImportGoodsDTO();
        dto.setGoodsName("大熊饼干");
        dto.setGoodsType("食品");
        dto.setGoodsCost(10.5F);
        dto.setGoodsPrice(20.0F);
        dto.setProductionDate("2021-06-13");
        dto.setDuration(90);
        dto.setImportGoodsSum(20);
        goodsService.importGoods(dto);
    }

    @Test
    void sellGoods() {
    }

    @Test
    void refundGoods() {
    }

    @Test
    void queryGoods() {
        List<GoodsVO> goodsVOList = goodsService.queryGoods(10);
        System.out.println("测试结果: ");
        for (GoodsVO goodsVO : goodsVOList) {
            System.out.println(goodsVO);
        }
    }

    @Test
    void queryFinanceSummary() {
        List<FinanceSummaryVO> financeSummary = goodsService.queryFinanceSummary("day");
        System.out.println("测试结果: 按天查询");
        for (FinanceSummaryVO summaryVO : financeSummary) {
            System.out.println(summaryVO);
        }
        List<FinanceSummaryVO> financeSummary2 = goodsService.queryFinanceSummary("month");
        System.out.println("测试结果: 按月查询");
        for (FinanceSummaryVO summaryVO : financeSummary) {
            System.out.println(summaryVO);
        }
    }
}