package com.software.demo.service.impl;

import com.software.demo.dao.SalesRecordMapper;
import com.software.demo.entity.StockEffectType;
import com.software.demo.entity.domain.SalesRecordDO;
import com.software.demo.entity.vo.SalesRecordVO;
import com.software.demo.entity.vo.StockRecordVO;
import com.software.demo.service.SalesRecordService;
import com.software.demo.util.ObjectTransformUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yjn
 * 2021/06/13
 */
@Service
public class SalesRecordServiceImpl implements SalesRecordService {

    @Resource(name = "salesRecordMapper")
    private SalesRecordMapper salesRecordMapper;

    @Override
    public List<SalesRecordVO> queryAllRecord() {
        List<SalesRecordVO> result = new ArrayList<>();
        List<SalesRecordDO> salesRecordDOList = salesRecordMapper.queryAllRecord();
        if (salesRecordDOList == null) {
            return new ArrayList<>();
        }
        for (SalesRecordDO salesRecordDO : salesRecordDOList) {
            SalesRecordVO temp = ObjectTransformUtil.transform(salesRecordDO, SalesRecordVO.class);
            result.add(temp);
        }
        return result;
    }
}
