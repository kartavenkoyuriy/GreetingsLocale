package com.ardas;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class GreetingsRussianLocaleTest {

    private GreetingsLocale greetingsLocale;
    private Calendar calendar;

    @Before
    public void setUp(){
        calendar = Calendar.getInstance();

        greetingsLocale = new GreetingsLocale(new Locale("ru", "RU"));
        greetingsLocale.setCalendar(calendar);
    }

    @Test
    public void isEveningNowForRussianLocale() throws Exception {
        calendar.set(Calendar.HOUR_OF_DAY, 19);
        assertEquals("Добрый вечер, Мир!", greetingsLocale.start());
        calendar.set(Calendar.HOUR_OF_DAY, 21);
        calendar.set(Calendar.MINUTE, 30);
        assertEquals("Добрый вечер, Мир!", greetingsLocale.start());
        calendar.set(Calendar.HOUR_OF_DAY, 22);
        calendar.set(Calendar.MINUTE, 59);
        assertEquals("Добрый вечер, Мир!", greetingsLocale.start());
    }

    @Test
    public void isDayNowForRussianLocale() throws Exception {
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        assertEquals("Добрый день, Мир!", greetingsLocale.start());
        calendar.set(Calendar.HOUR_OF_DAY, 14);
        calendar.set(Calendar.MINUTE, 30);
        assertEquals("Добрый день, Мир!", greetingsLocale.start());
        calendar.set(Calendar.HOUR_OF_DAY, 18);
        calendar.set(Calendar.MINUTE, 59);
        assertEquals("Добрый день, Мир!", greetingsLocale.start());
    }

    @Test
    public void isMorningNowForRussianLocale() throws Exception {
        calendar.set(Calendar.HOUR_OF_DAY, 6);
        assertEquals("Доброе утро, Мир!", greetingsLocale.start());
        calendar.set(Calendar.HOUR_OF_DAY, 7);
        calendar.set(Calendar.MINUTE, 30);
        assertEquals("Доброе утро, Мир!", greetingsLocale.start());
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 59);
        assertEquals("Доброе утро, Мир!", greetingsLocale.start());
    }

    @Test
    public void isNightNowForRussianLocale() throws Exception {
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        assertEquals("Доброй ночи, Мир!", greetingsLocale.start());
        calendar.set(Calendar.HOUR_OF_DAY, 2);
        calendar.set(Calendar.MINUTE, 30);
        assertEquals("Доброй ночи, Мир!", greetingsLocale.start());
        calendar.set(Calendar.HOUR_OF_DAY, 5);
        calendar.set(Calendar.MINUTE, 59);
        assertEquals("Доброй ночи, Мир!", greetingsLocale.start());
    }

}
