package org.cognizant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Main.class);

    public static void displayCountry() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        Country country = context.getBean("country", Country.class);

        Country anotherCountry =
                context.getBean("country", Country.class);

        LOGGER.debug("Country : {}", country);
        LOGGER.debug("Another Country : {}", anotherCountry);
    }

    public static void main(String[] args) {

        LOGGER.info("START");

        displayCountry();

        LOGGER.info("END");
    }
}