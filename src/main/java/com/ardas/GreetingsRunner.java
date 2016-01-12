package com.ardas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

public class GreetingsRunner {

    private static final Logger logger = LogManager.getLogger(GreetingsRunner.class.getName());

    public static void main(String[] args) {
        logger.debug("Start execution Greetings App");
        System.out.println(new GreetingsLocale().start());
        System.out.println(new GreetingsLocale(new Locale("ru", "RU")).start());
        logger.debug("Successful end execution Greetings App");
    }
}
