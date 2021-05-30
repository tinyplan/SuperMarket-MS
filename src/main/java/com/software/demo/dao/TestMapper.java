package com.software.demo.dao;

import com.software.demo.entity.po.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tinyplan
 * 2021/5/30
 */
@Repository
public interface TestMapper {

    List<Goods> getAllGoods();

}
