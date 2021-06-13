package com.software.demo.dao;

import com.software.demo.entity.domain.TotalCostDO;
import com.software.demo.entity.domain.TotalNumAndPriceDO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author tinyplan
 * 2021/06/13
 */
@SpringBootTest
class FinanceMapperTest {

    @Resource(name = "financeMapper")
    private FinanceMapper financeMapper;

    @Test
    void queryAllGoodsCost() {
        List<TotalCostDO> result = financeMapper.queryAllGoodsCost("2021-06-12", "2021-06-13");
        System.out.println(Arrays.toString(result.toArray()));
    }

    @Test
    void queryAllGoodsNumAndPrice() {
        List<TotalNumAndPriceDO> result = financeMapper.queryAllGoodsNumAndPrice("2021-06-11 00:00:00", "2021-06-12 00:00:00");
        System.out.println(Arrays.toString(result.toArray()));
    }
}