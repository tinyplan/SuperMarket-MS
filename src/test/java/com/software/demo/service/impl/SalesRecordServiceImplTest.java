package com.software.demo.service.impl;

import com.software.demo.service.SalesRecordService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author tinyplan
 * 2021/06/15
 */
@SpringBootTest
class SalesRecordServiceImplTest {

    @Resource(name = "salesRecordServiceImpl")
    private SalesRecordService salesRecordService;

    @Test
    void queryAllRecord() {
    }
}