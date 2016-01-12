package com.ardas;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class GreetingsDefaultLocaleTest {

    private GreetingsLocale greetingsLocale;
    private Calendar calendar;

    @Before
    public void setUp(){
        calendar = Calendar.getInstance();

        greetingsLocale = new GreetingsLocale();
        greetingsLocale.setCalendar(calendar);
    }

    @Test
    public void isEveningNowForDefaultLocale() throws Exception {
        calendar.set(Calendar.HOUR_OF_DAY, 19);
        assertEquals("Good evening, World!", greetingsLocale.start());
        calendar.set(Calendar.HOUR_OF_DAY, 21);
        calendar.set(Calendar.MINUTE, 30);
        assertEquals("Good evening, World!", greetingsLocale.start());
        calendar.set(Calendar.HOUR_OF_DAY, 22);
        calendar.set(Calendar.MINUTE, 59);
        assertEquals("Good evening, World!", greetingsLocale.start());
    }

    @Test
    public void isDayNowForDefaultLocale() throws Exception {
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        assertEquals("Good day, World!", greetingsLocale.start());
        calendar.set(Calendar.HOUR_OF_DAY, 14);
        calendar.set(Calendar.MINUTE, 30);
        assertEquals("Good day, World!", greetingsLocale.start());
        calendar.set(Calendar.HOUR_OF_DAY, 18);
        calendar.set(Calendar.MINUTE, 59);
        assertEquals("Good day, World!", greetingsLocale.start());
    }

    @Test
    public void isMorningNowForDefaultLocale() throws Exception {
        calendar.set(Calendar.HOUR_OF_DAY, 6);
        assertEquals("Good morning, World!", greetingsLocale.start());
        calendar.set(Calendar.HOUR_OF_DAY, 7);
        calendar.set(Calendar.MINUTE, 30);
        assertEquals("Good morning, World!", greetingsLocale.start());
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 59);
        assertEquals("Good morning, World!", greetingsLocale.start());
    }

    @Test
    public void isNightNowForDefaultLocale() throws Exception {
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        assertEquals("Good night, World!", greetingsLocale.start());
        calendar.set(Calendar.HOUR_OF_DAY, 2);
        calendar.set(Calendar.MINUTE, 30);
        assertEquals("Good night, World!", greetingsLocale.start());
        calendar.set(Calendar.HOUR_OF_DAY, 5);
        calendar.set(Calendar.MINUTE, 59);
        assertEquals("Good night, World!", greetingsLocale.start());
    }
}
