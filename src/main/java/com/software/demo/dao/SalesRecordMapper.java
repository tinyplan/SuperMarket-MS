package com.software.demo.dao;

import com.software.demo.entity.domain.SalesRecordDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yjn
 * 2021/06/13
 */
@Repository
public interface SalesRecordMapper {

    List<SalesRecordDO> queryAllRecord();

}
