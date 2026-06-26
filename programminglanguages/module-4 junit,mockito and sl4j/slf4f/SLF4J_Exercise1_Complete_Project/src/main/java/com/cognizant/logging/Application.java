
package com.cognizant.logging;

import com.cognizant.logging.service.LoggingService;

public class Application {
    public static void main(String[] args) {
        LoggingService service = new LoggingService();
        service.demonstrateLogging();
    }
}
