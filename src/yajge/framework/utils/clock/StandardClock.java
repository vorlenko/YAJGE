/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yajge.framework.utils.clock;

/**
 * The StandardClock class extends BaseClock. Will return the time in
 * milliseconds
 *
 *
 * Copyright 2015-2015 by Vladimir Orlenko
 *
 * @author bob
 * @version 0.1
 * @see
 */
public class StandardClock extends BaseClock {

    @Override
    public long getTime() {
        return System.currentTimeMillis();
    }

    @Override
    public int getDefaultUnit() {
        return UNIT_MILLIS;
    }

    @Override
    public void stampTime() {
        stampTime = getTime();
    }

    @Override
    public long getElapsedTime() {
        return getTime() - stampTime;
    }

    @Override
    public long getElapsedTime(int unit) {
        return (getElapsedTime() * unit) / getDefaultUnit();
    }
}
