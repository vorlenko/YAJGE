/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yajge.framework.utils.clock;

/**
 * The BaseClock class abstract base for timing.
 *
 *
 *
 * Copyright 2015-2015 by Vladimir Orlenko
 *
 * @author bob
 * @version 0.1
 * @see StandardClock
 */
public abstract class BaseClock {

    public long stampTime;

    public static final int UNIT_SECONDS = 1;           // 10^0
    public static final int UNIT_MILLIS = 1000;          // 10^3
    public static final int UNIT_MICROS = 1000000;      // 10^6
    public static final int UNIT_NANOS = 1000000000;    // 10^9

    /**
     * getTime return the current counter time of the clock.
     *
     * @return return the current counter time of the clock.
     */
    public abstract long getTime();

    /**
     * getDefaultUnit return the default unit in which the clock's time is
     * returned.
     *
     * @return return the default unit in which the clock's time is returned.
     */
    public abstract int getDefaultUnit();

    /**
     * stampTime saves the current counter time in a variable within the class.
     *
     */
    public abstract void stampTime();

    /**
     * getElapsedTime return the time difference between the current time and
     * the value stored in the save time method.
     *
     * @return return the time in milliseconds difference between the current
     * time and the value stored in the save time method.
     */
    public abstract long getElapsedTime();

    /**
     * getElapsedTime return the time difference between the current time and
     * the value stored in the save time method.
     *
     * @param unit Measurment unit for return
     *
     * @return return the time difference between the current time and the value
     * stored in the save time method in the given unit.
     */
    public abstract long getElapsedTime(int unit);
}
