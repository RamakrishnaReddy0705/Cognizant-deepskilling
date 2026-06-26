
package com.cognizant.logging.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(LoggingService.class);

    public void demonstrateLogging() {

        LOGGER.warn("Application started with warning demonstration");

        try {
            int result = 10 / 0;
            LOGGER.info("Result : {}", result);
        } catch (ArithmeticException ex) {
            LOGGER.error("Error occurred while performing division", ex);
        }

        LOGGER.warn("Application execution completed");
    }
}
