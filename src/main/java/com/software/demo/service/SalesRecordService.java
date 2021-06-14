package com.software.demo.service;

import com.software.demo.entity.vo.SalesRecordVO;

import java.util.List;

/**
 * @author yjn
 * 2021/06/13
 */
public interface SalesRecordService {

    List<SalesRecordVO> queryAllRecord();

}
