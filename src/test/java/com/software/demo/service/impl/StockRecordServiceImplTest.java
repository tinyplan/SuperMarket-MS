package com.software.demo.service.impl;

import com.software.demo.entity.vo.StockRecordVO;
import com.software.demo.service.StockRecordService;
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
class StockRecordServiceImplTest {

    @Resource(name = "stockRecordServiceImpl")
    private StockRecordService stockRecordService;

    @Test
    void queryAllRecord() {
        List<StockRecordVO> stockRecordVOList = stockRecordService.queryAllRecord();
        for (StockRecordVO stockRecordVO : stockRecordVOList) {
            System.out.println(stockRecordVO);
        }
    }
}