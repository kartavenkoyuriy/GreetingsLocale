package com.ardas;

import org.junit.Test;

public class GreetingsCommonTest {

    @Test
    public void nullLocaleShouldSetToDefaultLocale() throws Exception {
        GreetingsLocale greetingsLocale = new GreetingsLocale(null);
        greetingsLocale.start();
    }

    @Test
    public void nullCalendarShouldSetToCurrentDate() throws Exception {
        GreetingsLocale greetingsLocale = new GreetingsLocale();
        greetingsLocale.setCalendar(null);
        greetingsLocale.start();
    }
}
