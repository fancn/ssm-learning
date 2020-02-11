package com.mars.ssmlearing;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@SpringBootTest
class SsmLearingApplicationTests {

    @Autowired
    private SimpleDriverDataSource simpleDriverDataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(SsmLearingApplicationTests.class);

    @Test
    public void contextLoads() {
        String a = simpleDriverDataSource.getUrl();
        logger.info(a);
        logger.info("" + jdbcTemplate.getQueryTimeout());
    }

}
