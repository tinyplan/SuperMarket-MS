package com.software.demo.dao;

import com.software.demo.entity.domain.TotalCostDO;
import com.software.demo.entity.domain.TotalNumAndPriceDO;
import com.software.demo.entity.domain.TotalRefundDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tinyplan
 * 2021/06/13
 */
@Repository
public interface FinanceMapper {

    /**
     * 区间左闭右开
     */
    List<TotalCostDO> queryAllGoodsCost(@Param("start") String startDate, @Param("end") String endDate);

    /**
     * 区间左闭右开
     */
    List<TotalNumAndPriceDO> queryAllGoodsNumAndPrice(@Param("start") String startTime, @Param("end") String endTime);

    List<TotalRefundDO> queryAllGoodsRefund(@Param("start") String startDate, @Param("end") String endDate);

}
