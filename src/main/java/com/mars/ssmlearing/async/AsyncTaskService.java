package com.mars.ssmlearing.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncTaskService {

    @Async
    public void printNumber(Integer i) {
        log.info("print number " + i);
    }

}
