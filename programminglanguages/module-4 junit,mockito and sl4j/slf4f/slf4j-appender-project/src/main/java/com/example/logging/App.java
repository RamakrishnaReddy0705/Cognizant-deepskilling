package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.debug("Debug message - application started");
        logger.info("Info message - processing request");
        logger.warn("Warning message - potential issue detected");
        logger.error("Error message - something went wrong");

        simulateBusinessLogic();
    }

    private static void simulateBusinessLogic() {
        for (int i = 1; i <= 3; i++) {
            logger.info("Processing item {}", i);
        }
    }
}
