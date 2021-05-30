package com.software.demo;

import com.software.demo.util.TimeFormatUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        // 2021-05-05 13:50:47
        // LocalDateTime now = LocalDateTime.parse("2021-05-05 13:50:47", );
        // System.out.println(now);
        // System.out.println(now.format(TimeFormatUtil.FORMATTER));
    }

}
