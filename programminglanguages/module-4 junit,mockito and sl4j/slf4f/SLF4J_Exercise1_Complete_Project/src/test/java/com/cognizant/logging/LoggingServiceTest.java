
package com.cognizant.logging;

import com.cognizant.logging.service.LoggingService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LoggingServiceTest {

    @Test
    void testLoggingExecution() {
        LoggingService service = new LoggingService();

        assertDoesNotThrow(service::demonstrateLogging);
    }
}
