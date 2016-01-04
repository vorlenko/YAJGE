/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yajge.framework.utils.clock;

/**
 * The NanoClock class extends BaseClock. Will return the time in nanoseconds
 *
 *
 * Copyright 2015-2015 by Vladimir Orlenko
 *
 * @author bob
 * @version 0.1
 * @see
 */
public class NanoClock extends BaseClock {

    @Override
    public long getTime() {
        return System.nanoTime();
    }

    @Override
    public int getDefaultUnit() {
        return UNIT_NANOS;
    }

    @Override
    public void stampTime() {
        stampTime = getTime();
    }

    /**
     * getElapsedTime return the time difference between the current time and
     * the value stored in the save time method.
     *
     * @return return the time in nanoseconds difference between the current
     * time and the value stored in the save time method.
     */
    @Override
    public long getElapsedTime() {
        return getTime() - stampTime;
    }

    /**
     * getElapsedTime return the time difference between the current time and
     * the value stored in the save time method.
     *
     * @param unit Measurment unit for return
     *
     * @return return the time difference between the current time and the value
     * stored in the save time method in the given unit.
     */
    @Override
    public long getElapsedTime(int unit) {
        return (getElapsedTime() * unit) / getDefaultUnit();
    }

}
