package com.software.demo.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/**
 * @author tinyplan
 * 2021/5/30
 */
public class TimeUtil {

    public static final DateTimeFormatter FORMATTER_DATE =
            DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.CHINA);
    public static final DateTimeFormatter FORMATTER_TIME =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

    /**
     * 获取当前日期
     */
    public static String nowDate() {
        return nowDate(FORMATTER_DATE);
    }

    public static String nowDate(String pattern) {
        return nowDate(DateTimeFormatter.ofPattern(pattern, Locale.CHINA));
    }

    public static String nowDate(DateTimeFormatter formatter) {
        return LocalDate.now().format(formatter);
    }

    /**
     * 获取当前时间
     */
    public static String nowTime() {
        return nowTime(FORMATTER_TIME);
    }

    public static String nowTime(String pattern) {
        return nowTime(DateTimeFormatter.ofPattern(pattern, Locale.CHINA));
    }

    public static String nowTime(DateTimeFormatter formatter) {
        return LocalDateTime.now().format(formatter);
    }

    /**
     * 添加指定天数
     */
    public static String plusDay(String startDate, Integer during, String pattern) {
        return plusDay(startDate, during, DateTimeFormatter.ofPattern(pattern, Locale.CHINA));
    }

    public static String plusDay(String startDate, Integer during, DateTimeFormatter formatter) {
        LocalDate start = LocalDate.parse(startDate, formatter);
        return start.plusDays(during).format(formatter);
    }

    public static boolean isBeforeDate(String start, String end) {
        LocalDate startDate = LocalDate.parse(start, FORMATTER_DATE);
        LocalDate endDate = LocalDate.parse(end, FORMATTER_DATE);
        return startDate.isBefore(endDate);
    }

    public static String firstTimeOfDay(LocalDate now) {
        return now.atStartOfDay().format(TimeUtil.FORMATTER_TIME);
    }

    public static String firstTimeOfNextDay(LocalDate now) {
        return now.atStartOfDay().plusDays(1).format(TimeUtil.FORMATTER_TIME);
    }

    public static String firstDateOfMonth(LocalDate now) {
        return now.atStartOfDay().with(TemporalAdjusters.firstDayOfMonth()).format(FORMATTER_DATE);
    }

    public static String firstDateOfNextMonth(LocalDate now) {
        return now.atStartOfDay().with(TemporalAdjusters.firstDayOfNextMonth()).format(FORMATTER_DATE);
    }

    public static String firstTimeOfMonth(LocalDate now) {
        return now.atStartOfDay().with(TemporalAdjusters.firstDayOfMonth()).format(FORMATTER_TIME);
    }

    public static String firstTimeOfNextMonth(LocalDate now) {
        return now.atStartOfDay().with(TemporalAdjusters.firstDayOfNextMonth()).format(FORMATTER_TIME);
    }

}
