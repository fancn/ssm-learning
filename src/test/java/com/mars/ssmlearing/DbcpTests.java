package com.mars.ssmlearing;

import com.mars.ssmlearing.repository.dao.TestDao;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DbcpTests {

    @Autowired
    private TestDao testDao;

    private static final Logger logger = LoggerFactory.getLogger(DbcpTests.class);

    @Test
    public void testTransaction() {
//        testDao.transactionsBetweenTable();
        testDao.transactionsBetweenDb();
        logger.info("xxx");
    }

}
