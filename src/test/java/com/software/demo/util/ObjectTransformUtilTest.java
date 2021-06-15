package com.software.demo.util;

import com.software.demo.entity.po.StockRecord;
import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    void test() throws UnsupportedEncodingException {
        // LocalDate now = LocalDate.now();
        // System.out.println(TimeUtil.firstTimeOfDay(now));
        // System.out.println(TimeUtil.firstTimeOfNextDay(now));
        // System.out.println(TimeUtil.firstDateOfMonth(now));
        // System.out.println(TimeUtil.firstDateOfNextMonth(now));
        // System.out.println(TimeUtil.firstTimeOfMonth(now));
        // System.out.println(TimeUtil.firstTimeOfNextMonth(now));
        // System.out.println(TimeUtil.plusDay(TimeUtil.nowDate(), 3, TimeUtil.FORMATTER_DATE));
        // String pureNumber = "111111111111111123232131";
        // String pureChar = "/*-+2";
        // String pattern1 = "^[0-9]*$";
        // String pattern2 = "^[+\\-*/]*$";
        // System.out.println(Pattern.matches(pattern1, pureNumber));
        // System.out.println(Pattern.matches(pattern2, pureChar));
        String floatStr = "1.0";
        System.out.println(Pattern.matches("^\\d+(\\.\\d+)?$", floatStr));
        // System.out.println(DigestUtils.md5DigestAsHex("小熊饼干 2".getBytes()));
        // String str = "撒";
        // String newStr = new String(str.getBytes(StandardCharsets.ISO_8859_1));
        // String newStr1 = new String(str.getBytes("gbk"));
        // String newStr2 = new String(str.getBytes(StandardCharsets.US_ASCII));
        // System.out.println(str + str.length());
        // System.out.println(newStr + newStr.length());
        // System.out.println(newStr1 + newStr1.length());
        // System.out.println(newStr2 + newStr2.length());
    }
}