package com.software.demo.util;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author tinyplan
 * 2021/5/30
 */
public class TimeFormatUtil {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.CHINA);

}
