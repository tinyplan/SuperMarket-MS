package com.software.demo.service;

import com.software.demo.entity.vo.StockRecordVO;

import java.util.List;

/**
 * @author tinyplan
 * 2021/6/12
 */
public interface StockRecordService {

    List<StockRecordVO> queryAllRecord();

}
