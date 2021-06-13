package com.software.demo.util;

import com.software.demo.entity.po.StockRecord;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @author tinyplan
 * 2021/6/5
 */
class ObjectTransformUtilTest {

    @Test
    void transform() {
        // Goods goods = new Goods(IdUtil.generateGoodsId("小熊饼干"),"小熊饼干","饼干",
        //         10f,105f,"2015-3-3",40,"2016-6-7");
        // GoodsVO goodsVO = ObjectTransformUtil.transform(goods, GoodsVO.class);
        // System.out.println(goodsVO);
        String localDate = LocalDate.now().atStartOfDay().format(TimeUtil.FORMATTER_DATE);
        String localDateAfter = LocalDate.now().atStartOfDay().plusDays(1).format(TimeUtil.FORMATTER_DATE);
        System.out.println(localDate);
        System.out.println(localDateAfter);

        String localTime = LocalDate.now().atStartOfDay().format(TimeUtil.FORMATTER_TIME);
        String localTimeAfter = LocalDate.now().atStartOfDay().plusDays(1).format(TimeUtil.FORMATTER_TIME);
        System.out.println(localTime);
        System.out.println(localTimeAfter);

        LocalDateTime firstDayOfMonth = LocalDate.now().atStartOfDay().with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime lastDayOfMonth = LocalDate.now().atStartOfDay().with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(firstDayOfMonth.format(TimeUtil.FORMATTER_TIME));
        System.out.println(lastDayOfMonth.format(TimeUtil.FORMATTER_TIME));

    }

    @Test
    void getFieldForPreparedStatement() {
        System.out.println(ObjectTransformUtil.getFieldForPreparedStatement(StockRecord.class));
    }

    @Test
    void test() {
        LocalDate now = LocalDate.now();
        System.out.println(TimeUtil.firstTimeOfDay(now));
        System.out.println(TimeUtil.firstTimeOfNextDay(now));
        System.out.println(TimeUtil.firstDateOfMonth(now));
        System.out.println(TimeUtil.firstDateOfNextMonth(now));
        System.out.println(TimeUtil.firstTimeOfMonth(now));
        System.out.println(TimeUtil.firstTimeOfNextMonth(now));
    }
}