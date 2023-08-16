package com.kh.toyproject;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

@SpringBootTest
public class LogTest01 {
    private static final Logger logger = LoggerFactory.getLogger(LogTest01.class);
    @Test
    void logTest01() {
        logger.info("Example log from {}", Example.class.getSimpleName());
    }
}
