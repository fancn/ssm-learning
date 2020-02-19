package com.mars.ssmlearing;

import com.mars.ssmlearing.async.AsyncTaskService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SsmLearningApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(SsmLearningApplicationTests.class);

    @Autowired
    private AsyncTaskService asyncTaskService;

    @Test
    public void testAsync() {
        for (int i = 0; i < 1000; i++) {
            asyncTaskService.printNumber(i);
        }
    }

}
