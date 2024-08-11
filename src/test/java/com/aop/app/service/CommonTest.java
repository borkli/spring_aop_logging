package com.aop.app.service;

import com.aop.app.util.TestAppender;
import org.apache.logging.log4j.core.LoggerContext;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommonTest {

    @AfterEach
    protected void beforeEach() {
        getTestAppender().getEvents().clear();
    }

    protected void assertLogMessage(String key) {
        var events = getTestAppender().getEvents();
        boolean hasMessage = false;

        for (String message : events.keySet()) {
            if (message.contains(key)) {
                hasMessage = true;
                break;
            }
        }

        assertTrue(hasMessage);
    }

    private TestAppender getTestAppender() {
        return LoggerContext
            .getContext(false)
            .getConfiguration()
            .getAppender("TestAppender");
    }
}
