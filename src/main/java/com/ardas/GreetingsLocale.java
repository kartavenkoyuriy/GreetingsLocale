package com.ardas;

import com.sun.javafx.runtime.SystemProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

/*
Написать консольное приложение на java, с использованием maven.

Приложение должно выводить на экран приветственное сообщение, в зависимости от текущего времени суток.

Good morning, World! в 06:00 - 09:00
//тут, видимо, 06:00 - 08:59 и т.д.
Good day, World! в 09:00 - 19:00
Good evening, World! в 19:00 - 23:00
Good night, World! в 23:00 - 06:00

​Код должен содержать все возможные юнит-тесты и создавать читабельный лог файл.

Выводящиеся на консоль сообщения должны быть получены из message resource и зависеть от системной локали пользователя.
Сделать перевод на русский язык.
*/

public class GreetingsLocale {

    private static final Logger logger = LogManager.getLogger(GreetingsLocale.class.getName());

    private Locale currentLocale;
    private ResourceBundle message;
    private Calendar calendar = Calendar.getInstance();

    public GreetingsLocale() {
    }

    public GreetingsLocale(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }

    public String start() {
        if(currentLocale == null){
            currentLocale = Locale.getDefault();
            logger.debug("Locale set by default");
        }
        if(calendar == null){
            calendar = Calendar.getInstance();
        }

        logger.debug("Locale set to " + currentLocale.getDisplayName());

        logger.debug("Current time is " + calendar.getTime().toString());

        message = ResourceBundle.getBundle("GreetingsBundle", currentLocale);

        if(message == null){
            try {
                throw new IllegalArgumentException("message");
            } catch (IllegalArgumentException e){
                logger.warn("Instance created with errors", e);
            }
        }
        logger.debug("ResourceBundle file is attached");

        String dayPeriod = getDayPeriod();
        logger.debug("Period of the day is calculated:|" + dayPeriod + "|");

        String greetingMessage = getGreetingMessage(dayPeriod);
        logger.info(greetingMessage);

        return greetingMessage;
    }

    private String getDayPeriod() {
        try {
            if (isPeriodCorrect(calendar, 6, 8)) {
                return getDayPeriodToString("my.morning");
            } else if (isPeriodCorrect(calendar, 9, 18)) {
                return getDayPeriodToString("my.day");
            } else if (isPeriodCorrect(calendar, 19, 22)) {
                return getDayPeriodToString("my.evening");
            } else if (isPeriodCorrect(calendar, 23, 23) || isPeriodCorrect(calendar, 0, 5)) {
                return getDayPeriodToString("my.night");
            } else {
                logger.error("No such day period" + calendar.getTime().toString());
            }
        } catch (Exception e){
            logger.error("Some unexpected error", e);
        }
        logger.warn("Wrong return of day period");
        return null;
    }

    private boolean isPeriodCorrect(Calendar calendar, int timeFrom, int timeTo) {
        return calendar.get(Calendar.HOUR_OF_DAY) >= timeFrom && calendar.get(Calendar.HOUR_OF_DAY) <= timeTo;
    }

    private String getDayPeriodToString(String key) {
        return new String(message.getString(key).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }

    private String getGreetingMessage(String dayPeriod){
        return String.format("%s %s",
                dayPeriod, getDayPeriodToString("my.world"));
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}
