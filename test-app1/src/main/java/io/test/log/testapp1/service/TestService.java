package io.test.log.testapp1.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private Logger log = LogManager.getLogger(TestService.class);

    public void go() {
        log.info("Test Service method called");
    }
}
