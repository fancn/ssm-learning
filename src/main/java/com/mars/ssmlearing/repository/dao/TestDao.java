package com.mars.ssmlearing.repository.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TestDao {

    @Autowired
    @Qualifier("dbcpJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(TestDao.class);

    //mysql同一个库，不同表是可以事务的
    @Transactional
    public void transactionsBetweenTable() {
        jdbcTemplate.update("update ssm.problem_detail set is_feedback=4 where id=5 ");
        jdbcTemplate.update("insert into ssm.new_table values ((10))");
    }

    //mysql同一个实例，不同库也是可以事务的，前提是都是innodb引擎的
    @Transactional
    public void transactionsBetweenDb() {
        jdbcTemplate.update("update ssm.problem_detail set is_feedback=5 where id=5 ");
        jdbcTemplate.update("insert into ssm2.b_table values ((10))");
    }
}
