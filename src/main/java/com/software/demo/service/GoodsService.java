package com.software.demo.service;

import com.software.demo.entity.po.Goods;
import com.software.demo.entity.vo.GoodsVO;

import java.util.List;

/**
 * @author tinyplan
 * 2021/6/3
 */
public interface GoodsService {

    boolean modifyGoodsInfo(Goods goods);

    List<GoodsVO> queryGoods(Integer page, Integer limit);

    List<Goods> queryAllGoods();

}
