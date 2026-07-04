package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {
      private static final Logger logger= LoggerFactory.getLogger(SpringLearnApplication.class);
	public static void main(String[] args) {
		// Hands on one start
		logger.info("Main method has started");
		logger.info("START");
		SpringApplication.run(SpringLearnApplication.class, args);
		logger.debug(new Date().toLocaleString());
		logger.info("Main method has ended");
		logger.info("END");
		// Hands on two end
	}

}
