package com.software.demo.service.impl;

import com.software.demo.dao.TestMapper;
import com.software.demo.entity.po.Goods;
import com.software.demo.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tinyplan
 * 2021/5/30
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource(name = "testMapper")
    private TestMapper testMapper;

    public List<Goods> testQueryValid() {
        return testMapper.getAllGoods();
    }

}
