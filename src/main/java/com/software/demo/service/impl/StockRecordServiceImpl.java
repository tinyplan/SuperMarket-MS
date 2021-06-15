package com.software.demo.service.impl;

import com.software.demo.dao.StockRecordMapper;
import com.software.demo.entity.StockEffectType;
import com.software.demo.entity.domain.StockRecordDO;
import com.software.demo.entity.vo.StockRecordVO;
import com.software.demo.service.StockRecordService;
import com.software.demo.util.ObjectTransformUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tinyplan
 * 2021/6/12
 */
@Service
public class StockRecordServiceImpl implements StockRecordService {

    @Resource(name = "stockRecordMapper")
    private StockRecordMapper stockRecordMapper;

    @Override
    public List<StockRecordVO> queryAllRecord() {
        List<StockRecordVO> result = new ArrayList<>();
        for (StockRecordDO stockRecordDO : stockRecordMapper.queryAllRecord()) {
            StockRecordVO temp = ObjectTransformUtil.transform(stockRecordDO, StockRecordVO.class);
            temp.setEffectNum(StockEffectType.getDescByKey(stockRecordDO.getEffectType()) + stockRecordDO.getEffectNum());
            if (StockEffectType.SUBTRACT.getKey().equals(stockRecordDO.getEffectType())) {
                temp.setEffectType("销售");
            } else {
                if (stockRecordDO.getImportId() != null) {
                    temp.setEffectType("进货");
                } else {
                    temp.setEffectType("退款");
                }
            }
            result.add(temp);
        }
        return result;
    }
}
