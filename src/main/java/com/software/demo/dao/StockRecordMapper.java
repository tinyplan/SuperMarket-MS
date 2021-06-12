package com.software.demo.dao;

import com.software.demo.entity.domain.StockRecordDO;
import com.software.demo.entity.po.StockRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tinyplan
 * 2021/6/9
 */
@Repository
public interface StockRecordMapper {

    Integer maxId();

    Integer insertRecord(StockRecord record);

    /**
     * 查找所有的销售记录
     * import_id == null && 影响类型为减少(-1)
     */
    List<StockRecord> querySellRecord();

    List<StockRecordDO> queryAllRecord();

}
