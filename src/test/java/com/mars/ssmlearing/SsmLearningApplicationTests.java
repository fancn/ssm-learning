package com.mars.ssmlearing;

import com.mars.ssmlearing.repository.model.ProblemDetail;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class SsmLearningApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(SsmLearningApplicationTests.class);

    @Test
    public void contextLoads() {
        ProblemDetail detail = jdbcTemplate.queryForObject("select * from problem_detail where id = 5", (rs, rowNum) -> {
            ProblemDetail problemDetail = new ProblemDetail();
            problemDetail.setId(rs.getLong("id"));
            problemDetail.setDetail(rs.getString("detail"));
            return problemDetail;
        });
        logger.info(detail.toString());
    }

}
