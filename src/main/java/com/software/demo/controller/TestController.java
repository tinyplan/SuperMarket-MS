package com.software.demo.controller;

import com.software.demo.entity.po.Goods;
import com.software.demo.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tinyplan
 * 2021/5/30
 */
@Controller
public class TestController {

    @Resource(name = "testServiceImpl")
    private TestService testService;

    @ResponseBody
    @RequestMapping("/test")
    public List<Goods> test() {
        return testService.testQueryValid();
    }

}
